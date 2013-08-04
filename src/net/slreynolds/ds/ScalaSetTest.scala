package net.slreynolds.ds

import net.slreynolds.ds.export.GraphVizExporter;
import net.slreynolds.ds.export.TulipExporter;
import net.slreynolds.ds.export.ExporterOptions;
import net.slreynolds.ds.model.BuilderOptions;

import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.util.HashMap;

import scala.collection.JavaConversions._;

object ScalaSetTest extends AbstractScalaTest("../graphs/scala.test.set") {

  private def testDrop(size:Int, numDrop:Int): Unit = {
    validateDropArgs(size, numDrop)
    
    // --- Set ---
    var medium_set:Set[Bar] = Set()
    for (i <- Range(1,size+1)) {
      medium_set += new Bar(i)
    }
    if (numDrop > 0) {
      val smaller_set = medium_set.drop(numDrop)
      saveToFiles(medium_set::smaller_set::Nil, 
               "medium_set"::"smaller_set"::Nil,
               "sets" + size + "d" + numDrop)
    }
    else {
      saveToFiles(medium_set::Nil, 
               "medium_set"::Nil,
               "sets" + size + "d" + numDrop)
    }
  }

  def main(args: Array[String]): Unit = {
    testDrop(4,0)
    testDrop(5,0)
    testDrop(6,0)
    testDrop(4,1)
    testDrop(5,1)
    testDrop(6,1)
   
    print("Thanks for playing")
  }
    
}