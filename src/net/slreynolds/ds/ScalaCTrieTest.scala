package net.slreynolds.ds

import net.slreynolds.ds.export.GraphVizExporter;
import net.slreynolds.ds.export.TulipExporter;
import net.slreynolds.ds.export.ExporterOptions;
import net.slreynolds.ds.model.BuilderOptions;

import java.lang.Boolean;
import java.util.HashMap;

import scala.collection.JavaConversions._;

import scala.collection.parallel.mutable.ParTrieMap;

object ScalaCTrieTest extends AbstractScalaTest("../graphs/scala.ctrie") {

  
  def main(args: Array[String]): Unit = {
    
    // See http://docs.scala-lang.org/overviews/parallel-collections/overview.html
    //     http://docs.scala-lang.org/overviews/parallel-collections/performance.html
    //     http://docs.scala-lang.org/overviews/parallel-collections/conversions.html
    //     http://docs.scala-lang.org/overviews/parallel-collections/ctries.html
    

    
		  val map = ParTrieMap('a' -> 1, 'b' -> 2, 'c' -> 3,'d' -> 4, 'e' -> 5) 
		  val shorter_map = map drop(1)
		  saveToFiles(map:: shorter_map :: Nil, 
				  "map"::"shortermap"::Nil,
				  "map")
    
               /*
    // --- List ---
    val list = List(new Bar(1), new Bar(2)).par 
    val res_list = list map (x => new Bar(10*x.getID()))
    saveToFiles(list:: res_list:: Nil, 
                "list" :: "res_list" :: Nil,
               "list")
          
    val longer_list = 0.0 :: list;
    val shorter_list = list.drop(1)
    saveToFiles(list::longer_list::shorter_list::Nil, 
                "list"::"longer_list"::"shorter_list"::Nil,
                "lists")
   
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
    System.out.printf("array2 is %s, par_array2 is %s, res_array2 is %s imm_res2 is %s\n",
        array2.getClass().getName(),
        par_array2.getClass().getName(),
        res_array2.getClass().getName(),
        imm_res2.getClass().getName())
       
    // --- Set ---
    val set3 = Set("dog", "cat", "bird") 
    saveToFiles(set3, "set3")
    
    val small_set = Set(1.0,2.0,3.0,4.0,5.0)
    saveToFiles(small_set, "small_set")
    
    val medium_set = small_set.union(Set(6.0))
    saveToFiles(small_set::medium_set::Nil, 
               "small_set"::"medium_set"::Nil,
               "medium_set")
               
    val smaller_set = small_set.drop(1)
    saveToFiles(small_set::medium_set::smaller_set::Nil, 
               "small_set"::"medium_set"::"smaller_set"::Nil,
               "more_sets")

    
    // --- Map ---
    val map = Map('a' -> 1, 'b' -> 2, 'c' -> 3,'d' -> 4, 'e' -> 5) 
    val shorter_map = map drop(1)
    saveToFiles(map:: shorter_map :: Nil, 
               "map"::"shortermap"::Nil,
               "map")

    // Stream
    val str = 1 #:: 2 #:: 3 #:: Stream.empty
    saveToFiles(str, "stream_before")
    print(str.take(2).tail)
    saveToFiles(str, "stream_after")
    */
    
    print("Thanks for playing")
  }

}