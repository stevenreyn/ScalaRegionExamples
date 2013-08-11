package net.slreynolds.ds

import net.slreynolds.ds.export.GraphVizExporter;
import net.slreynolds.ds.export.TulipExporter;
import net.slreynolds.ds.export.ExporterOptions;
import net.slreynolds.ds.model.BuilderOptions;

import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.util.HashMap;

import scala.collection.JavaConversions._;

object ScalaMapTest extends AbstractScalaTest("../graphs/scala.test.map") {

  private def testCollision(): Unit = {
    val size = 6;
    // --- Map ---
    val bar1 = new Bar(1)
    var medium_map:Map[Bar,Foo] = Map()
    medium_map = medium_map + ((bar1,new Foo(1)))
    assert(medium_map.size == 1)
    assert(medium_map.get(bar1) != None)
    for (i <- Range(2,size)) {
      medium_map = medium_map + ((new Bar(i),new Foo(i)))
    }
    assert(medium_map.size == size-1)
    val before = medium_map
    val coll = 1 + 0x10000;
    val barColl = new Bar(coll)
    assert(bar1.## == barColl.##)
    medium_map = medium_map + ((barColl,new Foo(coll)))
    assert(medium_map.size == size)
    assert(medium_map.get(bar1) != None)
    assert(medium_map.get(barColl) != None)
    
    saveToFiles(before::medium_map::Nil, 
               "before"::"medium_set"::Nil,
               "mapscoll" + size + "d")
    
  }

  private def testDrop(size:Int, numDrop:Int): Unit = {
    validateDropArgs(size, numDrop)
    
    // --- Map ---
    var medium_map:Map[Bar,Foo] = Map()
    for (i <- Range(1,size+1)) {
      medium_map = medium_map + ((new Bar(i),new Foo(i)))
    }
   
    if (numDrop > 0) {
      val smaller_map = medium_map.drop(numDrop)
      saveToFiles(medium_map::smaller_map::Nil, 
               "medium_set"::"smaller_map"::Nil,
               "maps" + size + "d" + numDrop)
    }
    else {
      saveToFiles(medium_map::Nil, 
               "medium_set"::Nil,
               "maps" + size + "d" + numDrop)
    }
  }

  def main(args: Array[String]): Unit = {
    testDrop(4,0)
    testDrop(5,0)
    testDrop(6,0)
    testDrop(4,1)
    testDrop(5,1)
    testDrop(6,1)
    testCollision
   
    print("Thanks for playing")
  }
  

    
}