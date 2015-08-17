import mykafka.Globals;


public class JavaSandbox {
    public static void main(String[] args) throws Exception
    {
        /*
           val dimensionMetaData = Map("browser"->List(("IE",200),("FF",300), ("CH",500)), "country"->List(("IL",100),("US",400),("TH",500)), "gender"->List(("M",480),("F",450),("UNKN",70)))
           val dimensionGenerators : Map[String, RandomValueGenerator[String]] = dimensionMetaData.map({ case (k,v) => k-> new RandomValueGenerator[String](v) })
         */
        for (String dim : Globals.dimensions())
        {
            System.out.print(dim + "\t");
        }
        System.out.println();

        for (int i = 0; i<100; i++)
        {
            for (String dim : Globals.dimensions())
            {
                System.out.print(Globals.getNextRandomValue(dim) + "\t");
            }
            System.out.println();
        }
    }
}
