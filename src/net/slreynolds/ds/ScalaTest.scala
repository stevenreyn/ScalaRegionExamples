package net.slreynolds.ds


import scala.collection.immutable.HashMap

object ScalaTest extends AbstractScalaTest("../graphs/scala") {

  def main(args: Array[String]): Unit = {
    
    /*
     * See
     * http://docs.scala-lang.org/overviews/collections/introduction.html
     */
    
    // --- List ---
    val list = List(new Foo(1), new Foo(2)) 
    saveToFiles(list, "list")
    
    val x = list.tail
    val y = new Foo(0) :: list
    saveToFiles(list::x::y::Nil, "list"::"tail"::"pre-pend"::Nil, "list-ops")
        
    val longer_list = new Bar(0) :: list;
    val shorter_list = list.drop(1)
    saveToFiles(list::longer_list::shorter_list::Nil, 
                "list"::"longer_list"::"shorter_list"::Nil,
                "lists")
   
    
    // --- Vector ---
    val small_vector = Vector(new Bar(0), new Bar(1), new Bar(2)) 
    saveToFiles(small_vector, "small_vector")
    val chngd_vector = small_vector.:+(new Bar(3))
    saveToFiles(small_vector::chngd_vector::Nil, "small_vector"::"chngd_vector"::Nil,"vec-ops")
    
    val large_vector = small_vector ++ (Vector.range(3,33) map (i => new Bar(i)))
    val largest_vector = large_vector :+ new Bar(34)
    saveToFiles(large_vector::largest_vector::Nil, 
               "large_vector"::"largest_vector"::Nil, 
               "large_vector")
    
    
    // --- Set ---
    val set3 = Set(new Bar(1), new Bar(2), new Bar(3)) 
    saveToFiles(set3, "set3")
    
    val small_set = Set(new Bar(1), new Bar(2), new Bar(3), new Bar(4), new Bar(5))
    saveToFiles(small_set, "small_set")
    
    val medium_set = small_set.union(Set(new Bar(6)))
    saveToFiles(small_set::medium_set::Nil, 
               "small_set"::"medium_set"::Nil,
               "medium_set")
               
    val smaller_set = small_set.drop(1)
    saveToFiles(small_set::medium_set::smaller_set::Nil, 
               "small_set"::"medium_set"::"smaller_set"::Nil,
               "more_sets")

    
    // --- Map ---
    val map1 = Map(new Foo(1) -> new Bar(1), new Foo(2) -> new Bar(2))
    saveToFiles(map1::Nil, 
               "map1"::Nil,
               "map")      
               
    val map1_added = map1 + (new Foo(3) -> new Bar(3))
    saveToFiles(map1:: map1_added :: Nil, 
               "map1"::"map1_added"::Nil,
               "map-ops")
           
    val map2 = Map(new Foo(1) -> new Bar(1), new Foo(2) -> new Bar(2), 
              new Foo(3) -> new Bar(3), new Foo(4) -> new Bar(4), new Foo(5) -> new Bar(5)) 
    val shorter_map = map2 drop(1)
    saveToFiles(map2:: shorter_map :: Nil, 
               "map2"::"shortermap"::Nil,
               "shorten-map")
               
    val hmap = HashMap.apply(new Foo(1) -> new Bar(1), new Foo(2) -> new Bar(2))
    saveToFiles(hmap::Nil, 
               "hmap"::Nil,
               "hashmap")    
               
    val hmap_added = hmap + (new Foo(3) -> new Bar(3))
    saveToFiles(hmap:: hmap_added :: Nil, 
               "hmap"::"hmap_added"::Nil,
               "hmap-ops")       
               
    val hmap_chngd = hmap_added + (new Foo(3) -> new Bar(30))
    saveToFiles( hmap_added :: hmap_chngd ::Nil, 
                "hmap_added"::"hmap_chngd" :: Nil,
                "hmap-ops2")  
               
    /*           
    val map1_added = map1 + (new Foo(3) -> new Bar(3))
    saveToFiles(map1:: map1_added :: Nil, 
               "map1"::"map1_added"::Nil,
               "map-ops")               
    */
    // Stream
    val str = new Foo(1) #:: new Foo(2) #:: new Foo(3) #:: Stream.empty
    saveToFiles(str, "stream_before")
    //print(str.take(2).tail)
    saveToFiles(str, "stream_after")

    // TODO Seq?
    
    print("Thanks for playing")
  }

}