package net.slreynolds.ds

import net.slreynolds.ds.export.GraphVizExporter;
import net.slreynolds.ds.export.TulipExporter;
import net.slreynolds.ds.export.ExporterOptions;
import net.slreynolds.ds.model.BuilderOptions;

import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.util.HashMap;

import scala.collection.JavaConversions._;

object ScalaVectorMovie extends AbstractScalaTest("../graphs/scala.vector.movie") {


  private def addToEnd(myVec:Vector[Bar], next:Int): Vector[Bar] = {
     
    val nextVec = myVec :+ new Bar(next)
    saveToFiles(nextVec::Nil, 
               "vector"::Nil,
               "vector" + (next+1) )
    nextVec
  }

  def main(args: Array[String]): Unit = {
    
    var myVector = Vector(new Bar(0))
    saveToFiles(myVector::Nil, 
               "myVector"::Nil,
               "vector" + 1)
    for (i <- 1 to 60) {
      myVector = addToEnd(myVector,i)
    }
   
   
    print("Thanks for playing")
  }
  

    
}