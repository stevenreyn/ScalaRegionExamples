package net.slreynolds.ds

import scala.collection.immutable.HashMap

object ScalaMapMovie extends AbstractScalaTest("../graphs/scala.map.movie") {

  private def addToMap(myMap:Map[Bar,Foo], fileNum:Int, barID:Int): Map[Bar,Foo] = {
    
    val nextMap = myMap + ((new Bar(barID), new Foo(barID)))
    saveToFiles(nextMap::Nil, 
               "map"::Nil,
               "map" + (fileNum) )
    nextMap
  }

  def main(args: Array[String]): Unit = {
    var myMap:Map[Bar,Foo] = HashMap.apply((new Bar(0) -> new Foo(0)))
    saveToFiles(myMap::Nil, 
               "map"::Nil,
               "map" + 1)
    
    for (i <- 2 to 35) {
      myMap = addToMap(myMap,i,(i-1)*32)
    }
    print("Thanks for playing")
  }
  

    
}