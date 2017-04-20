package com.mulesoft.maelstrom.dsl

import org.yaml.snakeyaml.Yaml

class Test {

    static void main (String[] args) {
        Yaml parser = new Yaml()
        Project project = new Project()
        project.asset="assetTest"
        project.product="productTest"
        project.profile="profileTest"
        Phase p1 = new Phase()
        p1.name="p1"
        p1.enabled=false
        Phase p2 = new Phase()
        p2.name="p2"
        p2.enabled=true
        Phase p3 = new Phase()
        p3.name="p3"
        p3.enabled=true
        Phase p4 = new Phase()
        p4.name="p4"
        p4.enabled=false
        List phases = new ArrayList<Phase>()
        phases.add(p1)
        phases.add(p2)
        phases.add(p3)
        phases.add(p4)
        project.phases=phases
        System.out.println(parser.dump(project))

        //        List example = parser.load(("example.yaml" as File).text)

    }

}
