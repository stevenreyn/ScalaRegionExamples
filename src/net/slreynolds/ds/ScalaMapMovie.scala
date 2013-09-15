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
    
    myMap = addToMap(myMap,2,32)
    myMap = addToMap(myMap,3,2*32)
    myMap = addToMap(myMap,4,3*32)
    myMap = addToMap(myMap,5,4*32)
    
    print("Thanks for playing")
  }
  

    
}