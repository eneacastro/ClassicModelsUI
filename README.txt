MODIFICACIONES REALIZADAS CON RESPECTO A LA ENTREGA ANTERIOR:
COMENTARIOS DEL PROFESOR:
- Interface details (hide cantidad buttons in employee view, consultar mis clientes list, autoselect textfields in login and new customer form, disable modificar compra button in other views, producto cantidad edit size in multiple digits ...)

- Delete customers, employees: fk constraint fails.

- Create new employee reportsTo trigger.

- Logout instead of Close.

- Compra producto seleccionado por busqueda: array index out of bounds exception.

- Inconsistency between orders and orderdetails when product out of stock: use transaction. Also when carrito is empty.

- For each order in employee view: view orderdetails.

- Autoupdate state when it changes.

- Create different users/profiles for DB acces.


MODIFICACIONES REALIZADAS:

-Botones escondidos de carrito, añadir y cantidad en empleado.

-Cerrar sesión en lugar de cerrar el programa.

-Arreglado compra del producto por búsqueda, ( el error era que faltaba una columna y cogía la que no tocaba y daba error).

-Creados los permisos y aplicado a la parte de Cliente.