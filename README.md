# 2-_Parcial

## Nota:
Mi repositorio es: https://github.com/samuug/2-_Parcial.git


## Ejercicio 1

1) Los elementos que definen a un objeto son:
  a) El tipo de visibilidad que tiene asignado: privado o público.
  b) La identidad, Los atributos que representan su estado y los métodos que representan su
  comportamiento.

  Respuesta : b

2) El hecho de que un método pueda recibir un número variable de atributos se denomina:
  a) Herencia
  b) Polimorfismo

  Respuesta : b

3) Imagine que la clase C hereda de la clase B. Y la clase B hereda de la clase A. Cuando se cree
  un objeto de la clase C, ¿cuál será la secuencia en que se ejecutarán los constructores?
  a) Primero el constructor de C, luego constructor de B y, finalmente, el constructor de A
  b) Primero el constructor de A, luego constructor de B y, finalmente, el constructor de C
  Respuesta : a

4) Para referenciar los atributos de un objeto en un método de la misma clase
  a) Debo utilizar la palabra reservada self como prefijo
  b) Los atributos deben ser públicos, en caso contrario no se pueden referenciar desde
  métodos que no sean el constructor.étodos que no sean el constructor.étodos que no
  sean el constructor.
  Respuesta : a

5) En el paradigma de la programación orientado a objetos:
  a) Se recomienda que las acciones estén lo más acopladas posibles al código para
  obtener el mayor rendimiento posible.
  b) Se favorece la semántica y la reutilización de código en detrimento del rendimiento.
  Respuesta : b
 
## Ejercicio 2
### ¿Cuáles son las características de la programación orientada a objetos?  
1.	Abstracción: permite representar los elementos del mundo real en forma de objetos, identificando las características y comportamientos relevantes para el sistema que se está construyendo.  
2.	Encapsulamiento: consiste en la ocultación de la información dentro del objeto, lo que permite proteger los datos y controlar el acceso a ellos desde el exterior. Los métodos del objeto proporcionan una interfaz para acceder y manipular la información encapsulada.  
3.	Herencia: es un mecanismo que permite definir una clase en función de otra existente, heredando sus propiedades y métodos. De esta forma, se pueden reutilizar elementos de código existentes y construir clases más especializadas y específicas.  
4.	Polimorfismo: es la capacidad de un objeto para responder a un mismo mensaje o método de diferentes maneras, en función del contexto. Permite tratar objetos de diferentes clases como si fueran del mismo tipo, lo que facilita la creación de código más genérico y reutilizable.  
En general, la POO promueve el diseño modular, la reutilización de código, la extensibilidad y la mantenibilidad de los sistemas.  

## Ejercicio 3
### ¿Qué es la visibilidad de una variable o un método? ¿Qué tipos hay? ¿Cuándo debe utilizarse cada tipo?
La visibilidad en programación orientada a objetos se refiere al nivel de acceso que tiene una variable o un método desde fuera de la clase en la que se definen. Los diferentes tipos de visibilidad son los siguientes:  
1.	Public: las variables y métodos con este modificador son accesibles desde cualquier parte del programa, incluso desde fuera de la clase en la que se definen.  
2.	Private: las variables y métodos con este modificador solo son accesibles desde dentro de la clase en la que se definen. No pueden ser accedidos ni modificados desde fuera de la clase. 
3.	Protected: las variables y métodos con este modificador son accesibles desde dentro de la clase en la que se definen y desde las clases derivadas o subclases. No pueden ser accedidos desde fuera de la clase ni desde objetos de otras clases.  
4.	Package/Default: las variables y métodos que no tienen ningún modificador de visibilidad explícito (en algunos lenguajes se les llama "paquete" o "amistoso") son accesibles desde dentro del paquete en el que se definen. No pueden ser accedidos desde fuera del paquete.    
La elección de la visibilidad adecuada depende del contexto y la funcionalidad del programa que se está diseñando. En general, se recomienda utilizar la visibilidad más restrictiva posible para mantener el encapsulamiento y la cohesión de las clases, evitando que se acceda o modifique información de manera inapropiada desde fuera de la clase. Por ejemplo, se suelen utilizar variables y métodos privados para proteger la información interna de una clase, y métodos públicos para proporcionar una interfaz pública clara y segura para que los clientes de la clase interactúen con ella. En el caso de la visibilidad "protected", se utiliza principalmente para heredar miembros de una clase a sus subclases y facilitar la reutilización de código. La visibilidad "package/default" es útil para compartir información entre clases de un mismo paquete, pero no se recomienda utilizarla fuera de este contexto ya que puede afectar a la seguridad y mantenibilidad del código.
