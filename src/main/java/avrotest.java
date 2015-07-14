import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;

import java.io.ByteArrayOutputStream;

/**
 * Created by odedrotem on 7/14/15.
 */
public class avrotest {
    public static void main(String[] args) throws Exception
    {
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(new java.io.File("/Users/odedrotem/dev/kafka-test/src/main/java/schema.avsc"));
        GenericRecord datum = new GenericData.Record(schema);
        datum.put("left", "L");
        datum.put("right", "R");
        System.out.println(datum.toString());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DatumWriter<GenericRecord> writer =
                new GenericDatumWriter<GenericRecord>(schema);
        Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        writer.write(datum, encoder);
        encoder.flush();

        out.close();
        DatumReader<GenericRecord> reader =
                new GenericDatumReader<GenericRecord>(schema);
        Decoder decoder = DecoderFactory.get().binaryDecoder(out.toByteArray(),
                null);
        GenericRecord result = reader.read(null, decoder);
        System.out.println(result);
        //result.get("left").toString(), is("L"));
        //result.get("right").toString(), is("R"));
    }
}