# API de servicios FAPP

## Requerimientos

* Java: OpenJDK 17.0.3+7
* Eclipse: 2022-06 (4.24.0) build id:20220609-1112
* Spring plugin: Spring Tool Suite 4
* SAP PowerDesigner: 16.6.10.0(6261)

---

## Descripcion

- Servicios, entidades JPA, objetos jaxb, manejo de documentos segun especificacion del SII, firma electronica y, en general, funcionalidades relacionadas (es el core de los documentos SII)
- Proyecto tipo Eclipse/Springboot.
- Proyecto compuesto de diferentes modulos Maven desarrollados con Springboot.
<br>
<br>
**NOTA:** El modulo **jaxb** no debiera volver a generarse.
       Se recomienda tomar respaldo del codigo actual, en caso que por error se ejecute un build que regenere el codigo, **perdiendo los cambios que se han realizado a algunas clases jaxb**

---
## Ejecutar la aplicacion en Linux

El siguiente comando iniciara el servicio en background, enviando su salida/error estandar al archivo indicado.

```shell
 nohup /<PATH_JAVA>/java -jar <API JAR PACKAGE>.jar > ./nohup--fapp-sii-api-services.out 2>&1 &
```

## Copyright

&copy; Transformapp 2022. Todos los derechos reservados.