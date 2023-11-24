##

NumberPublisher (1-300)

CollectingSubscriber für

* exakt eine Zahl (dann subscr.cancel)
* 5 ganze Zahlen (dann subscr.cancel)
* ist durch 10 teilbar
* ist Quadratzahl
* ist Primzahl
* Skip-Predicate, dann Keep-Count, dann Cancel


## 

Schreiben Sie einen Processor, der jeweils zwei Zahlen zu einer verdichtet.

## 

Schreiben Sie einen Subscriber, der pro Item zwischen 1 und 5 Sekunden arbeiten muss. Er soll 
insgesamt exakt 1 Minute laufen -- und nach jedem Item ggf. zusätzliche Items nachfragen, sodass
er schlußendlich bei einer Laufzeit von einer Minute endet.