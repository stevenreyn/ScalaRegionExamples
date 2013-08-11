package net.slreynolds.ds

import net.slreynolds.ds.export.GraphVizExporter;
import net.slreynolds.ds.export.TulipExporter;
import net.slreynolds.ds.export.ExporterOptions;
import net.slreynolds.ds.model.BuilderOptions;

import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.util.HashMap;

import scala.collection.JavaConversions._;
import scala.collection.immutable.IntMap;

object ScalaPrimitiveMapTest extends AbstractScalaTest("../graphs/scala.test.primmap") {

  private def testAMap(): Unit = {
    val size = 6;
    // --- Map ---
    
    var medium_map:IntMap[Foo] = IntMap()
    medium_map = medium_map + (1,new Foo(1))
    assert(medium_map.size == 1)
    assert(medium_map.get(1) != None)
    for (i <- Range(2,size)) {
      medium_map = medium_map + (i,new Foo(i))
    }
    assert(medium_map.size == size-1)
    val before = medium_map
   
    
    saveToFiles(before::Nil, 
               "before"::Nil,
               "amap" + size + "d")
    
  }

  private def testDrop(size:Int, numDrop:Int): Unit = {
    validateDropArgs(size, numDrop)
    
    // --- Map ---
    var medium_map:IntMap[Foo] = IntMap()
    for (i <- Range(1,size+1)) {
      medium_map = medium_map + (i,new Foo(i))
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
    testAMap
   
    print("Thanks for playing")
  }
  

    
}