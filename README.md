# Spring-Boot-Crud
Api RestFull Spring boot, @Maven, @Mysql Workbench.
![EstructuraDeProyecto](https://github.com/Luiso-o/Spring-Boot-Crud/assets/128043647/676cde11-6289-4a5c-adb6-a476e62ac84b)

Tenemos una entidad llamada "Fruta", que dispone de las siguientes propiedades:

int id

String nombre

Int cantidadQuilos

Aprovechando la especificación JPA, deberás persistir esta entidad en una base de datos Mysql, siguiendo el patrón MVC. Para ello, dependiendo del Package principal, crearás una estructura de packages, donde ubicarás las clases que necesites:

cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.controllers
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.Entity
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.services
cat.itacademy.barcelonactiva.apellidos.nombre.s04.t02.n01.model.repository
La clase ubicada en el paquete controllers (FruitaController, por ejemplo), deberá ser capaz de dar respuesta a las siguientes peticiones para actualizar y consultar información:

http://localhost:8080/fruta/add
![ADD](https://github.com/Luiso-o/Spring-Boot-Crud/assets/128043647/30b944de-a092-4484-91d7-028e09a67aab)

http://localhost:8080/fruta/update
![Update](https://github.com/Luiso-o/Spring-Boot-Crud/assets/128043647/e34053b3-cb0d-4c10-b61f-abf1e7bb35e8)

http://localhost:8080/fruta/delete/{id}
![Delete](https://github.com/Luiso-o/Spring-Boot-Crud/assets/128043647/885dc7f6-52ce-4616-b5b2-eac94a0d2028)

http://localhost:8080/fruta/getOne/{id}
![getOne](https://github.com/Luiso-o/Spring-Boot-Crud/assets/128043647/82ead5b9-f7a6-498c-984b-2945fe84ea93)

http://localhost:8080/fruta/getAll
![getAll](https://github.com/Luiso-o/Spring-Boot-Crud/assets/128043647/cd697d23-a442-4bca-8ee3-5120aff5932d)



