Reead me

Java serialization relies on some optimization (using ref.):

Java works  storing only references to objects that were already serialized. 

So in our example, if You send the object:

Person [firstName=John, lastName=Doe]

and then:
change name and send again:
    p.setFirstName("BAD!!!!!");
    out.writeObject(p);

you WONT see the second value!

Try experiment it.

FIX: issue a "reset" ON STREAM to make java serialization forget previous ref to 
the same object.

Note: it happens if You change a value of a property, 
NOT if You create an object from scratch.




