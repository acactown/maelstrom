package com.mulesoft.maelstrom.dsl.parser

import com.mulesoft.maelstrom.dsl.Phase
import com.mulesoft.maelstrom.dsl.Project
import org.yaml.snakeyaml.Yaml

class MaelstromDeclarationParser {

  private static Yaml parser = new Yaml()

  public static Project fromYAMLFile (String path) {
    return fromYAML((path as File).text)
  }

  public static Project fromYAML (String text) {
    return parser.loadAs(text, Project.class)
  }

  public static String toYAML (Project project) {
    return parser.dump(project)
  }

  public static void main (String[] args) {
    Project project = new Project()
    project.asset = "assetTest"
    project.product = "productTest"
    project.profile = "profileTest"
    Phase p1 = new Phase()
    p1.name = "p1"
    p1.enabled = false
    Phase p2 = new Phase()
    p2.name = "p2"
    p2.enabled = true
    Phase p3 = new Phase()
    p3.name = "p3"
    p3.enabled = true
    Phase p4 = new Phase()
    p4.name = "p4"
    p4.enabled = false
    List phases = new ArrayList<Phase>()
    phases.add(p1)
    phases.add(p2)
    phases.add(p3)
    phases.add(p4)
    project.phases = phases

    String yaml = toYAML(project)
    println(yaml)
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    project = fromYAMLFile("")
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    yaml = toYAML(project)
    println(yaml)
  }

}
