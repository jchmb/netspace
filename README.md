NetSpace
========

Notice
------

NetSpace is still in the early stages of development and therefore the API may change dramatically. Use at your own risk.

What is NetSpace?
-----------------

NetSpace is a Java library developed to aid easy development of network games using an entity-component-system framework. NetSpace treats entities as residing on a network.

Any client/server network can create private entities (not shared with others) and any server can create public entities that are shared with the clients. Any time a public entity is created on the server side, the same entity is replicated on every client (or just some clients, if you want to make some entities hidden to some clients). Likewise, any time a public entity is destroyed on the server side, the same entity is destroyed on every other client, because every entity is identified by a unique ID.

Like in any other entity-component-system framework, entities have components that may be attached and detached. The behavior of entities is completely determined by its components. In this framework, some components may be server-only (e.g., keeping track of hidden scores/stats), while other components may be client-only (e.g., related to the UI).

Features
--------

* Easily create and share entities with everyone on a network.
* Define behavior through pluggable **components**.
* Entities have internal events, called **signals**, so that components can communicate with each other.
* NetSpace is completely agnostic about any underlying rendering system. Even something basic like position has been left out, so that the user is not forced to use any specific system.

Dependencies
------------

* JDK 8.
* NetSpace depends heavily on [KryoNet](https://github.com/EsotericSoftware/kryonet), which is responsible for the networking and serialization of objects.

Examples
--------

* An example of NetSpace with LibGDX can be found here: https://github.com/jchmb/netspace-example-libgdx
