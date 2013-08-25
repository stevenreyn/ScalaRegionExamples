package net.slreynolds.ds

import net.slreynolds.ds.export.GraphVizExporter;
import net.slreynolds.ds.export.SimpleGraphVizExporter;
import net.slreynolds.ds.export.ExporterOptions;
import net.slreynolds.ds.model.BuilderOptions;

import java.lang.Boolean;
import java.util.HashMap;

import scala.collection.JavaConversions._;

abstract class AbstractScalaTest(val path: String) {

  def saveToFiles(obj: Object, name: String) : Unit = {
    saveToFiles(obj :: Nil, name :: Nil, name)
  }
  
  def saveToFiles(objs: List[Object], names: List[String], fileName:String) : Unit = {
    val gvizSaver = new ObjectSaver(new GraphVizExporter())
    val simpleGVizSaver = new ObjectSaver(new SimpleGraphVizExporter())
    val options = new HashMap[String,Object]()
    options.put(BuilderOptions.INLINE_STRINGS,Boolean.FALSE)
    options.put(ExporterOptions.OUTPUT_PATH, path++"/"++fileName++".dot")
    gvizSaver.save(objs,names, options)
    options.put(ExporterOptions.OUTPUT_PATH, path++"/"++fileName++"_simple.dot")
    simpleGVizSaver.save(objs,names, options)
  }
  
  def validateDropArgs(size: Int, numDrop: Int): Unit = {
    if (numDrop > size) throw new IllegalArgumentException("numDrop cannot be larger than size")
    if (numDrop < 0) throw new IllegalArgumentException("numDrop cannot be negative")
    if (size < 1) throw new IllegalArgumentException("size must be at least one")
  }
}