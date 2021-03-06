package net.slreynolds.ds


import scala.collection.parallel.immutable.ParSeq;
import scala.collection.parallel.immutable.ParVector;

object ScalaParTest extends AbstractScalaTest("../graphs/scala.test.par") {

  
  def main(args: Array[String]): Unit = {
    
    // See http://docs.scala-lang.org/overviews/parallel-collections/overview.html
    //     http://docs.scala-lang.org/overviews/parallel-collections/performance.html
    //     http://docs.scala-lang.org/overviews/parallel-collections/conversions.html
    //     http://docs.scala-lang.org/overviews/parallel-collections/ctries.html
    
    /*
     * List.par == ParSeq == ParVector. Both have ParVector
     */
    
    // --- List ---
    val list = List(new Bar(1), new Bar(2)).par 
    val res_list = list map (x => new Bar(10*x.getID()))
    saveToFiles(list:: res_list:: Nil, 
                "list" :: "res_list" :: Nil,
               "list")
               
    /*
    val longer_list = 0.0 :: list;
    val shorter_list = list.drop(1)
    saveToFiles(list::longer_list::shorter_list::Nil, 
                "list"::"longer_list"::"shorter_list"::Nil,
                "lists")
    */
    
    // --- ParSeq ---
    val small_parseq = ParSeq(new Bar(0), new Bar(1), new Bar(2)) 
    saveToFiles(small_parseq, "small_parseq")
    
    // --- Vector ---
    val small_parvector = ParVector(new Bar(0), new Bar(1), new Bar(2)) 
    saveToFiles(small_parvector, "small_parvector")
    
    
    // --- appending ---
    val large_vector = small_parvector ++ (Vector.range(3,33) map (i => new Bar(i)))
    val largest_vector = large_vector :+ new Bar(34)
    saveToFiles(large_vector::largest_vector::Nil, 
               "large_vector"::"largest_vector"::Nil, 
               "large_vector")
    
    // --- Use case 1 ---
    val vector = Vector(new Bar(0), new Bar(1), new Bar(2), new Bar(3), new Bar(4), new Bar(5)) 
    val par_vector = vector.par
    val res_vector = par_vector map (x => new Bar(20*x.getID()))
    saveToFiles(List(vector,par_vector,res_vector), 
                List("vector","par_vector","res_vector"),
                "use_case1_vector")
    
    // --- Use case 2 ---
    val array2 = Array(new Bar(0), new Bar(1), new Bar(2), new Bar(3), new Bar(4), new Bar(5))
    val par_array2 = array2.par
    val res_array2 = par_array2 map (x => new Bar(20*x.getID()))
    val imm_res2 = res_array2.toVector
    saveToFiles(List(array2,par_array2,res_array2, imm_res2), 
                List("array","par_array2","res_array2","imm_res2"),
                "use_case2_array")
    /*
    System.out.printf("array2 is %s, par_array2 is %s, res_array2 is %s imm_res2 is %s\n",
        array2.getClass().getName(),
        par_array2.getClass().getName(),
        res_array2.getClass().getName(),
        imm_res2.getClass().getName())
        */
           
    
    print("Thanks for playing")
  }

}