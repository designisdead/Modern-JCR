# A Modern API to use JCR with Streams

[![Build Status](https://travis-ci.org/designisdead/Modern-JCR.svg?branch=master)](https://travis-ci.org/zwaldeck/modern-jcr)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2053f6a7c6ee4583940ee68d1bc7ddd5)](https://www.codacy.com/app/designisdead/Modern-JCR?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=designisdead/Modern-JCR&amp;utm_campaign=Badge_Grade)
[![Coverage Status](https://coveralls.io/repos/github/designisdead/Modern-JCR/badge.svg?branch=master)](https://coveralls.io/github/designisdead/Modern-JCR?branch=master)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)



## License

The source code is licensed under the [Mit License, Version 2.0](https://opensource.org/licenses/MIT).

## Java

This library requires Java 8 or up.

## Usage

1. Add dependency to your project (For example maven:)
```
<dependency>
    <groupId>com.designisdead.zwaldeck</groupId>
    <artifactId>modernjcr</artifactId>
    <version>1.0.0</version>
</dependency>
```
2. Convert NodeIterator to a Stream and use it (Listing all nodes of a certain type)
```
Node rootNode = jcrSession.getRootNode();
ModernJcr.asStream(rootNode.getNodes())
                .filter(node -> node.getPrimaryNodeType().isNodeType("sling:folder"))
                .forEach(node -> System.out.println("Name: " + node.getName()));

```

## Resources

- Javadoc: