**Dice Roller**

**Dice Roller** es una aplicación sencilla desarrollada con **Jetpack Compose** que permite a los usuarios lanzar dados virtuales. La aplicación incorpora animaciones de **Lottie** para ofrecer una experiencia visual atractiva y permite a los usuarios personalizar el número de lados de los dados. 
Este proyecto tiene como objetivo aplicar los conceptos fundamentales de desarrollo de aplicaciones móviles aprendidos en la materi Desarrollo de Aplicaciones Moviles I.

**Cómo Ejecutar la Aplicación**
Para ejecutar la aplicación, sigue estos pasos:

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu-usuario/dice-roller.git
2. Abre el proyecto en Android Studio.
3. Asegúrate de tener el SDK de Android instalado y configurado correctamente.
4. Ejecuta la aplicación en un emulador o en un dispositivo físico.

**Componentes Principales Utilizados
-Button: Utilizado para realizar acciones principales, como lanzar el dado.
-Image: Muestra imágenes relevantes dentro de la aplicación.
-Slider: Permite a los usuarios controlar el número de lados del dado.
-Lottie Animations: Se utilizan para añadir animaciones interactivas.
-Uso de Modifiers

**La aplicación emplea diversos modificadores para gestionar aspectos como:
**-Tamaño: Modifier.size(), fillMaxWidth().
-Padding y Margen: padding(), margin().
-Alineación: align(), Arrangement.

**Gestión de Estado**
Se utiliza ViewModel junto con mutableStateOf para manejar el estado de los componentes. La aplicación incluye variables de estado mutables que reflejan los cambios en tiempo real en la interfaz de usuario.

**Navegación**
En su estado actual, la aplicación cuenta con una única pantalla (Home). Se planea implementar navegación adicional en el futuro para incluir pantallas secundarias, como Detalles y Configuración.

**Requisitos**
-Kotlin
-Jetpack Compose
-Lottie para las animaciones

**Contribuciones**
Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un "issue" o envía un "pull request".

**Contacto**
Si tienes alguna pregunta o sugerencia, no dudes en contactarme a través de jd.garcia011@ebc.edu.mx
