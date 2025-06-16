# <h1 align="center">GAMEHUB_PROYECTO</h1>

<h1>Miembros:</h1>

- <h4>Daniel David Durango Pérez</h4>
- <h4>Juan Manuel Esquivel Vergara</h4>
- <h4>Santiago Maya Ospina</h4>

## Manual de Usuario:

A continuación, se estará dando una breve explicación del funcionamiento del programa para los usuarios. Esto se logra apreciar de manera clara y sencilla en las siguientes presentaciones.

### Vista del Login (Inicio).

En la siguiente vista se podrá apreciar lo que sería el login (Sistema de autenticación de usuarios) se debe llenar los campos para iniciar la sesión, en caso de que no tenga un usuario registrado puede dirigirse hasta el apartado de registro, si preciona el boton "Singn in" que se encuentra ubicada el la parte inferior de la pantalla al lado del botón iniciar sesión ( Login ): ![image](https://github.com/user-attachments/assets/70847a1c-cf49-4e98-9809-ff97b838a8b3) El boton lo llevará a registrar un administrador o un usuario de pendiendo de el apartado de inicio que se encuentre.


<h5>Login de Clientes</h5>      

![image](https://github.com/user-attachments/assets/51af5165-5c91-464d-a0b3-336b8b531c0f)

<h5>Login de Administradores</h5>

![image](https://github.com/user-attachments/assets/3a86fa80-506f-413d-942e-e4e916a96e2f)

### Vista de Registro (Crea tu usuario).

En esta vista te encontrás con los campos correspondientes para la creacion de un nuevo usuario para el programa, debes asegurarte de que los datos estén ubicados correctamente y que el dato realmente corresponda a la información solicitada para que no ocurranigún error a la hora de crear el usuario.

![image](https://github.com/user-attachments/assets/d6a766af-7cdf-41d0-84a1-a7f74563a62e)

### Vista Principal (Tienda)

Esta es la vista donde el usuario podrá ingresar despues de llenar sus datos de incio, tendrá una variedad de opciones bastante amplias esto relacionado con la compra de video juegos, solo los administradores podrán acceder al apartado de historial de compras.

![image](https://github.com/user-attachments/assets/b2576af3-3312-4eac-b7c1-de6a7a83f488)

### Opcion de Perfil.

Acá en este apartado tendrás una opción para cerrar la sesión.

![image](https://github.com/user-attachments/assets/ca09ecfb-0b35-439d-add3-ab1618c223f0)

### Apartado para añadir juegos al carrito. al los favoritos o comprarlos directamente.

En este apartado puedes mirar los requisitos funcionales sobre el juego que desea comprar y las diferentes ocpiones para añadir los juegos a la lista de favoritos o al carrito.

![image](https://github.com/user-attachments/assets/5fe9e130-b6f3-4622-a647-c9b8e8c268c3)

### Apartado de favoritos.

En este apartado verás todos los juegos que te gustaría tener, en la biblioteca, tienes opciones para filtrar los juegos que son gratis y los que son de pago o listar todos los juegos. Desde aquí puedes enviar un juego al panel del carrito si asi lo deseas.

![image](https://github.com/user-attachments/assets/9eff8b6a-ccf4-469b-8a4e-a0c1c2052c7d)

### Apartado del Carrito

En este apartado podrás dirigirte hasta el apartado de pagos y pagar todos los juegos que tenas en el carrito, si alguno de esos no lo deseas aún encima del item del juego te aparecerá la opción de eliminarlo o de pasarlo a la lista de favoritos.

![image](https://github.com/user-attachments/assets/434bc8a7-7ca5-48a1-b2ed-6638555df1d5)

### Apartado de pagos.

Acá podrá realizar todas o finlaizar las compras de los juegos que desea adquirir, selecionando su banco preferido eh ingresando los datos correspondientes.

![image](https://github.com/user-attachments/assets/4ff320b3-5de9-4b85-96d3-148091e6ac43)

### Apartado de biblioteca

En este partado aparecerás todos los juegos que has adquirido.

![image](https://github.com/user-attachments/assets/89ad50e4-1555-49ec-9931-d8fffdee91f0)

## Apartado de historial de compras

Apartado al cual solo podrán acceder los administradores del programa, para llevar un control de los juegos más vendidos y en que fechas.

![image](https://github.com/user-attachments/assets/fff7b784-3f05-404c-99e9-d56ecec0302c)

## Manual de Desarrollador:

Acontinuación tenemos la explicación o la demostración de de la solucion en el codigo fuente(Contenido para desarrolladores).

<table align="center">
  <tr>
          <h3 align="center">Tabla de Clases</t3>
  </tr>
  <tr>
          <th>Clases</th>
          <th>Descripción</th>
  </tr>
  <tr>
          <td>App.java</td>
          <td>Esta clase se encaraga de tomar el FXML de la pagina que se iniciará cuando se ejecute el programa carga la vista y lanza la aplicación</td>
  </tr>
  <tr>
          <td>Instacias.java</td>
          <td>Esta clase implementa el patrón de diseño singleton y gestiona las instancias de los modelos de datos</td>
  </tr>
  <tr>
          <td>List_Doble_Admin.java</td>
          <td>Esta clase implementa los metodos para almacenar y gestionar administradores, guarda estos en archivos.txt para la persistencia de los datos</td>
  </tr>
  <tr>
          <td>List_Doble_Client.java</td>
          <td>Esta clase implementa los metodos para almacenar y gestionar clientes, guarda estos en archivos.txt para la persistencia de los datos</td>
  </tr>  
  <tr>
          <td>Stack_Games.java</td>
          <td>Esta clase plementa cuatro pilas Stack que gestionan los diferentes archivos.txt y pilas de juegos en la aplicación</td>
  </tr>
  <tr>
          <td>Admin.java</td>
          <td>Esta clase implementa los atributos y metodos necesarios para cargar la información de administradores en la lista administradores</td>
  </tr>
  <tr>
          <td>Client.java</td>
          <td>Esta clase implementa los atributos y metodos necesarios para cargar la información de clientes en la lista clientes</td>
  </tr>
  <tr>
          <td>Game.java</td>
          <td>Esta clase implementa los atributos y metodos necesarios para cargar la información de los juegos en las pilas Stack</td>
  </tr>
  <tr>
          <td>Styles.css</td>
          <td>Esta hoja.css implemeta los estlos para la vista principal</td>
  </tr>
          
</table>

<table align="center"> 
      <tr>
            <h3 align="center">Tabla de Vistas</h3>
      </tr>
      <tr>
            <th>Vista</th>
            <th>Controllador</th>
            <th>Cescripción</th>
      </tr>
      <tr>
            <td>GAMEHUB.fxml</td>
            <td>GAMEHUBController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar he asignar las acciones de los botones y demás</td>
      </tr>
      <tr>
            <td>Login.fxml</td>
            <td>LoginController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los eventos onClick </td>
      </tr>
      <tr>
            <td>SignUP.fxml</td>
            <td>SingUPController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los metodos de escritura y lectura de los datos de los usuarios</td>
      </tr>
      <tr>
            <td>game_card.fxml</td>
            <td>GameCardController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los eventos de los botones en la carta de los juegos en el carrito de compras</td>
      </tr>
      <tr>
            <td>game_card_fav.fxml</td>
            <td>GameCardFavController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los eventos de los botones en la carta de los juegos en la lista de favoritos</td>
      </tr>
      <tr>
            <td>game_card_library.fxml</td>
            <td>GameCardLibraryController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los elementos visuales en la carta de los juegos en la biblioteca</td>
      </tr>
      <tr>
            <td>game_card_purchase.fxml</td>
            <td>GameCardPurchaseController.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los elementos visuales en la carta de los juegos en el apartado de pago</td>
      </tr>
</table>

## Prototipo de Figma:

Enlace para el prototipo: [enlace](https://www.figma.com/design/QcOLM4VnaQjJViVNxaTUtt/Prototype_GAME_VERSE?node-id=0-1&t=8u0L6xB1ygdAVBs2-1](https://www.figma.com/design/6clpYWbY6TTvSg9XIAb0Td/PROTOTIPO-DEL-SISTEMA?node-id=0-1&t=HdDOOxmcNLH4TmiE-1))

