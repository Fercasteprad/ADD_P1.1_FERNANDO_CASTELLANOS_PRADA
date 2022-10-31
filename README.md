# ADD_P1.1_FERNANDO_CASTELLANOS_PRADA
Práctica 1 de acceso a datos.

Crea un programa de login en Java, en modo consola, que pida al usuario su nombre y
contraseña para acceder al sistema.
Los usuarios con los que se validarán los datos introducidos estarán almacenados en el
fichero acceso.txt (se adjunta con este documento) con el formato user:pass.
1. Diseña la clase Usuario para mapear cada línea del fichero con los datos de los
usuarios.
2. Si el usuario introduce las credenciales correctamente, el sistema informará con
un mensaje "Hola <usuario>", siendo <usuario> el nombre del usuario utilizado
para acceder.
3. En caso contrario, si el usuario existe pero la contraseña no coincide, se pedirá de
nuevo la clave, con un número máximo de intentos por usuario registrado.
4. Si se sobrepasa ese número máximo de intentos, se bloqueará a dicho usuario (no
podrá logarse más), pero dejará acceder al resto de usuarios no bloqueados
registrados en el fichero.
5. Si el usuario no se encuentra en el fichero se realizará el alta del mismo. Se
pedirán los datos del nuevo usuario (solo la contraseña, manteniendo el nombre
de usuario introducido y que no se encuentra registrado) y se almacenarán en el
fichero de acceso, estando así disponible para poder entrar en el sistema con el
nuevo usuario.
6. Al darse de alta se realizará un doble check de la contraseña introducida, es decir,
deben de coincidir las dos veces que se solicite, en caso contrario, se volverá a
solicitar la contraseña al usuario de manera indefinida, pudiendo salir mediante
una opción concreta del menú correspondiente.
7. Cada vez que se realice un login o intento del mismo, se almacenará en un fichero
login.log con la fecha y hora de dicho intento, registrando si el intento ha sido
correcto o no junto con el nombre de usuario que lo ha intentado (una línea por
intento).
8. Si el usuario se loga como administrador (admin), además del saludo
correspondiente, podrá desbloquear a los usuario bloqueados, pudiendo estos
volver a intentar logarse.
La idea del sistema de bloqueo se podrá realizar de manera libre utilizando cualquier
método (explicándolo en el documento README.txt).
