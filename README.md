                                        |-----------------------------------Spanish-----------------------------------|
Claves de este repositorio:
1- El unico push en la rama master es la de la entidad user y su controller, service, implementación del servicio(userImplService), repository y su respectivo dto.
2- Cuando hago un nuevo crud creo una nueva rama y despues hago un merge a la rama test.
3- Los patrones de diseño que uso son los adquiridos con la experiencia laboral (adaptandome rapidamente al patron de diseño de la empresa en la que estaba).
Estos son DTO y ImplService (ejemplo la clase "UserImplService", la cual implementa de la interface "UserService" y es en la implementación del servicio donde se escribe toda la lógica.
La idea es evitar escribirla en el controlador para buenas prácticas).
Ejemplo básico:

UserController:

private UserService userService
@GetMapping("/users")
public ResponseEntity<List<User>> findAllUsers(){
  userService.findAllUsers();
}

UserService:

ResponseEntity<List<User>> findAllUsers();

UserImplService:

@Autowired
UserRepository userRepository;

public ResponseEntity<List<User>> findAllUsers(){
  List<User> users = userRepository.findAll();
  return ResponseEntity.ok(users);
}

4- Por buenas prácticas, todos los métodos devuelven una respuesta http, todos retornan un ResponseEntity.
5- La base de datos se encuentra funcionando perfectamente en la nube MongoDB Atlas.
6- El otro patrón de diseño que uso es "DTO" (Data transfer Object), yo lo uso principalmente para cuando un usuario quiere obtener datos de otro usuario, se retorna un "UserDTO",
no un "User", ya que User posee datos sensibles como el Id (o en otras ocasiones adress, mail adress etc) y el dto del usuario no muestra información sensible.
7- Hasta ahora tengo hecho hasta la entidad Organization el cual tiene relación con Users con DBRef(DataBase Reference).


                                        |-----------------------------------English-----------------------------------|
Key Points in this repository:

1- When i make another CRUD, i create a new branch and then i do a merge to test.
2- Design Patterns in this applications are dto and services implements, ej: interface "UserService" that is implemented by "UserImplService" where i write all the logic code.
The idea of this is to avoid writing logic code in the controller.
basic ej:
UserController:

private UserService userService
@GetMapping("/users")
public ResponseEntity<List<User>> findAllUsers(){
  userService.findAllUsers();
}

UserService:

ResponseEntity<List<User>> findAllUsers();

UserImplService:

@Autowired
UserRepository userRepository;

public ResponseEntity<List<User>> findAllUsers(){
  List<User> users = userRepository.findAll();
  return ResponseEntity.ok(users);
}
3- For good practices, all methods return an http response, all of them return a ResponseEntity.
4- The DataBase is working perfectly in the cloud MongoDB Atlas.
5- The other design pattern is "DTO" Data Transfer Object, i use it specifically to prevent any user to get sensitive information of another user (like Id, in other cases Adress 
maybe). That is posible because the method return an UserDTO and not an User.
6- until now i've made User and Organization entities, those have a relation made with DBRef.
7- The only push i've done to master, is UserCRUD (version 1).
# carta-application
