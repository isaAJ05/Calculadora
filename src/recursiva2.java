
import javax.swing.SwingConstants;

public class recursiva2 extends javax.swing.JFrame {

    
    //Variables Globales
    //Entrada usuario
    String acum;
    //Para comprobar si el usuario dividio un numero entre 0
    int error = 0;
    //Para comprobar si se necesita  un parentesis en las funciones sen, cos, tan
    boolean p = false;

    //Subrutina para que aparezca el numero en el label de resultado
    public void aparecer(String caracter) {
        res.setHorizontalAlignment(SwingConstants.RIGHT);
        acum = acum + caracter;
        res.setText(acum);
    }

    //VALIDACIONES
    //validar si ultimo caracter es un digito o no
    public boolean caracternumerico(String cadena) {
        boolean c = false;
        for (int i = 0; i < 10; i++) {
            String i2 = Integer.toString(i);
            if (cadena.substring(cadena.length() - 1).equals(i2)) {
                return c = true;
            }
        }
        return c;
    }

    public boolean validacion2(String cadena) {
        char ultimoCaracter = cadena.charAt(cadena.length() - 1);
        if (ultimoCaracter == '(') {
            return true;
        }
        return false;
    }

    //Funcion para validar que se borre el operador si el usuario desea otro
    public boolean validacion(String cadena) {
        if (cadena.length() == 0) {
            return true; // Manejar caso de cadena vacía
        }

        char ultimoCaracter = cadena.charAt(cadena.length() - 1);

        if (!Character.isDigit(ultimoCaracter)) {
            return false; // Manejar caso de carácter no numérico
        }

        int ultimoValor = Integer.parseInt(String.valueOf(ultimoCaracter));

        for (int i = 0; i < 10; i++) {
            if (ultimoValor == i) {
                return true;
            }
        }

        return false;
    }

    //validar multiplicar un numero despues de e o pi
    public void validar(String cadena) {
        if (acum.length() == 0) {
            aparecer(cadena);
            operaciones.setText("");
        } else if (acum.substring(acum.length() - 1).equals("i") || acum.substring(acum.length() - 1).equals("e")) {
            aparecer("*"+cadena);
            operaciones.setText("");
        } else {
            aparecer(cadena);
            operaciones.setText("");
        }
    }

    //validar multiplicar sen, cos, tan despues de e o pi
    public void validar2(String cadena) {
        if (acum.length() == 0) {
            aparecer(cadena);
            parentesis.setVisible(true);//visualizacion de parentesis para el usuario
            p = true;
        } else if (acum.substring(acum.length() - 1).equals("i") || acum.substring(acum.length() - 1).equals("e")) {
            aparecer("*"+cadena);
            parentesis.setVisible(true);//visualizacion de parentesis para el usuario
            p = true;
        } else {
            aparecer(cadena);
            parentesis.setVisible(true);//visualizacion de parentesis para el usuario
            p = true;
        }
    }

    //validar que se sobreescriba un operador sobre otro
    public void validar3(String cadena) {
        if (acum.length() != 0 && acum.substring(acum.length() - 1) != "i") {
            if (acum.substring(acum.length() - 1).equals("i")) {

            } else {
                if (validacion2(acum) == false) {
                    if (validacion(acum) == false) {
                        acum = acum.substring(0, acum.length() - 1);
                        res.setText(acum);
                    }
                }
            }
        }
        if (acum.length() == 0) {
            operaciones.setText("Opcion no valida");
        } else if (acum.substring(acum.length() - 1).equals("(")) {
            operaciones.setText("Opcion no valida");
        } else {
            aparecer(cadena);
            operaciones.setText("");
        }
    }

    //eliminar decimal .0
    public static String eliminarCero(String cadena) {
        int longitud = cadena.length();
        if (longitud >= 2 && cadena.substring(longitud - 2).equals(".0")) {
            cadena = cadena.substring(0, longitud - 2);
        }
        return cadena;
    }

    //OPERACIONES (HAY QUE VOLVER ALGUNAS ITERATIVAS SI SE PUEDE)
    //multiplicacion
    public static double multiplicacion(double a, double b) {
        double resultado = 0.0;

        return a * b;
    }

    // Division
    public double division(double dividendo, double divisor) {
        if (divisor == 0) {
            operaciones.setText("El divisor no puede ser cero");

        }

        return dividendo / divisor;
    }

    // Division entera
    public double divisionentera(double divi, double divis) {
        int dividendo = (int) divi;
        int divisor = (int) divis;

        return dividendo / divisor;
    }

    //suma
    public static double suma(double numero1, double numero2) {
        double suma = numero1 + numero2;
        return suma;
    }

    //resta
    public static double resta(double numero1, double numero2) {

        return numero1 - numero2;
    }

    //factorial
    public static double factorial(double n) {
        int entero = (int) n;
        if (entero == 0) {
            return 1;
        } else {
            return entero * factorial(entero - 1);
        }
    }

    //pi
    public static double Pi(int iteraciones) {
        double pi = 0.0;
        int signo = 1;
        for (int i = 0; i < iteraciones; i++) {
            double termino = 1.0 / (2 * i + 1);
            pi += signo * termino;
            signo *= -1;
        }

        return pi * 4.0;
    }

    //potencia
    public static double potencia(double base, double exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente debe ser un número no negativo.");
        }

        double resultado = 1.0;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }

        return resultado;
    }

    //euler elevado
    public static double exponencial(double x, int iteraciones) {
        double exponencial = 1.0;
        double termino = 1.0;

        for (int i = 1; i <= iteraciones; i++) {
            termino *= x / i;
            exponencial += termino;
        }

        return exponencial;
    }

    //seno 
    public static double seno(double x) {
        double seno = 0;
        double termino = x;

        for (int i = 1; i <= 10; i++) {
            seno += termino;
            termino *= -1 * x * x / ((2 * i) * (2 * i + 1));
        }

        return seno;
    }
    //coseno
    public static double coseno(double x) {
        double coseno = 0;
        double term = 1;

        for (int i = 0; i <= 10; i++) {
            coseno += term;
            term *= -1 * x * x / ((2 * i + 1) * (2 * i + 2));
        }

        return coseno;
    }

    //CALCULO DE EXPRESIONES
    //Esta funcion evalua factorial,pi, exponencial y funciones sen, cos, tan  para que al momento de realizar operaciones estos numeros ya esten definidos
    public String comprobar(String expresion) {
        boolean hayCambios = true;//por si hay varios de estas mismas funciones

        while (hayCambios == true) {
            hayCambios = false;

            if (expresion.contains("!")) {//si hay un factorial se evalua enseguida
                int indiceExclamacion = expresion.indexOf("!");
                int indiceInicioNumero = obtenerIndiceInicioNumero(expresion, indiceExclamacion);
                int indiceFinNumero = indiceExclamacion;

                String numeroStr = expresion.substring(indiceInicioNumero, indiceFinNumero);
                double numero = Double.parseDouble(numeroStr);

                double factorial = factorial(numero);
                expresion = expresion.replaceFirst(numeroStr + "!", String.valueOf(factorial));
                hayCambios = true;
                System.out.println("expresion: " + expresion);
            }

            if (expresion.contains("pi")) {//si hay un numero pi se evalua enseguida
                double valorPi = Pi(10);
                expresion = expresion.replace("pi", String.valueOf(valorPi));
                hayCambios = true;
                System.out.println("expresion: " + expresion);
            }
            if (expresion.contains("e") && !expresion.contains("sen")) {
                int indiceEuler = expresion.indexOf("e");
                int indiceSen = expresion.indexOf("sen");

                // Verificar que "sen" no se encuentre antes o después de "e"
                if ((indiceSen == -1) || (indiceSen > indiceEuler)) {

                    if (indiceEuler != -1) {
                        double exponencial = exponencial(1, 10000);
                        expresion = expresion.replaceFirst("e", String.valueOf(exponencial));
                        hayCambios = true;
                        System.out.println("expresion: " + expresion);
                    }

                }
            }
            if (expresion.contains("sen(")) {
                int signo = 1;

                if (expresion.contains("sen(-")) {
                    signo = -1;
                    expresion = expresion.replace("-", "");
                }

                int indiceSeno = expresion.indexOf("sen(");

                if (indiceSeno != -1) {
                    int indiceFinNumero = obtenerIndiceFinalNumero(expresion, 4, indiceSeno);
                    String numeroStre = expresion.substring(indiceSeno + 4, indiceFinNumero);
                    double valor = Double.parseDouble(numeroStre);
                    double seno = seno(valor);
                    String numeroNuevoStr = String.valueOf(seno * signo);

                    expresion = expresion.substring(0, indiceSeno) + numeroNuevoStr + expresion.substring(indiceFinNumero + 1);

                    hayCambios = true;
                }
            }

            if (expresion.contains("cos(")) {//si hay una funcion coseno se evalua enseguida
                int signo2 = 1;
                if (expresion.contains("cos(-")) {
                    signo2 = -1;
                    expresion = expresion.replace("-", "");
                }
                int indiceCos = expresion.indexOf("cos(");
                if (indiceCos != -1) {
                    int indiceFinNumero = obtenerIndiceFinalNumero(expresion, 4, indiceCos);
                    String numeroStre = expresion.substring(indiceCos + 4, indiceFinNumero);
                    double valor = Double.parseDouble(numeroStre);
                    double coseno = coseno(valor * signo2);
                    String numeroNuevoStr = String.valueOf(coseno);
                    expresion = expresion.substring(0, indiceCos) + numeroNuevoStr + expresion.substring(indiceFinNumero + 1);
                    hayCambios = true;
                }
            }
            if (expresion.contains("tan(")) {//si hay una funcion tangente se evalua enseguida
                int signo3 = 1;
                if (expresion.contains("tan(-")) {
                    signo3 = -1;
                    expresion = expresion.replace("-", "");
                }
                int indiceTan = expresion.indexOf("tan(");
                if (indiceTan != -1) {
                    int indiceFinNumero = obtenerIndiceFinalNumero(expresion, 4, indiceTan);
                    String numeroStre = expresion.substring(indiceTan + 4, indiceFinNumero);
                    double valor = Double.parseDouble(numeroStre);
                    double tangente = division(seno(valor * signo3), coseno(valor));
                    String numeroNuevoStr = String.valueOf(tangente);
                    expresion = expresion.substring(0, indiceTan) + numeroNuevoStr + expresion.substring(indiceFinNumero + 1);
                    hayCambios = true;
                }
            }

        }

        return expresion;
    }

    //   Funciones para obtener indices   
    public static int obtenerIndiceInicioNumero(String expresion, int indiceExclamacion) {
        for (int i = indiceExclamacion - 1; i >= 0; i--) {
            char caracter = expresion.charAt(i);
            if (!(caracter >= '0' && caracter <= '9') && caracter != '.') {
                return i + 1;
            }
        }
        return 0;
    }

    public static int obtenerIndiceFinalNumero(String expresion, int num, int indiceValor) {
        int longitudExpresion = expresion.length();
        for (int i = indiceValor + num; i < longitudExpresion; i++) {
            char caracter = expresion.charAt(i);
            if (!(caracter >= '0' && caracter <= '9') && caracter != '.') {
                return i;
            }
        }
        return longitudExpresion;
    }

    public double evaluarExpresion(String expresion) {

        // Eliminar los espacios en blanco de la expresión
        expresion = expresion.replaceAll("\\s", "");
        // Validar si el primer elemento es "-"
        if (expresion.substring(0, 1).equals("-")) {
            expresion = "0" + expresion;
        }

        // Buscar el operador de mayor precedencia
        int index = encontrarOperadorPrecedente(expresion);

        // Si no se encuentra ningún operador, la expresión es un número único
        if (index == -1) {
            return Double.parseDouble(expresion);
        }

        // Evaluar las subexpresiones izquierda y derecha de acuerdo al operador encontrado
        double izquierda = evaluarExpresion(expresion.substring(0, index));
        double derecha = evaluarExpresion(expresion.substring(index + 1));

        // Realizar la operación correspondiente
        switch (expresion.charAt(index)) {
            //suma
            case '+':
                return suma(izquierda, derecha);
            //resta
            case '-':
                return resta(izquierda, derecha);
            //multiplicacion
            case '*':
                return multiplicacion(izquierda, derecha);
            //division
            case '/':
                if (derecha == 0) {
                    error = 1;
                    operaciones.setText("El divisor no puede ser cero");//VALIDACION

                } else {
                    error = 0;
                    operaciones.setText("");
                    return division(izquierda, derecha);
                }
            //modulo
            case '%':
                return izquierda % derecha;
            //potencia
            case '^':
                return potencia(izquierda, derecha);
            //division entera
            case 'd':
                if (derecha == 0) {
                    operaciones.setText("El divisor no puede ser cero");//VALIDACION    
                    error = 1;
                } else {
                    error = 0;
                    operaciones.setText("");
                    return divisionentera(izquierda, derecha);
                }

        }

        // En caso de que ocurra un error
        throw new IllegalArgumentException("Expresión inválida");
    }

    //     Función para encontrar el operador de mayor precedencia en una expresión
    private static int encontrarOperadorPrecedente(String expresion) {
        int nivelParentesis = 0;
        int indexOperador = -1;
        int precedenciaActual = Integer.MAX_VALUE;

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (caracter == '(') {
                nivelParentesis++;
            } else if (caracter == ')') {
                nivelParentesis--;
            } else if (nivelParentesis == 0 && (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '%' || caracter == '^' || caracter == 'd')) {
                int precedencia = obtenerPrecedencia(caracter);

                if (precedencia <= precedenciaActual) {
                    precedenciaActual = precedencia;
                    indexOperador = i;
                }
            }
        }

        return indexOperador;
    }

    //   Función para obtener la precedencia de un operador
    private static int obtenerPrecedencia(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '^') {
            return 3;

        } else if (operador == '*' || operador == '/' || operador == '%' || operador == '^' || operador == 'd') {
            return 2;

        }

        return 0;
    }

    public recursiva2() {
        initComponents();
        this.setLocationRelativeTo(null);//centrar ventana
        this.setResizable(false);
        acum = "";

        parentesis.setVisible(false);
        error = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        operaciones = new javax.swing.JLabel();
        parentesis = new javax.swing.JButton();
        res = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setContentAreaFilled(false);

        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setContentAreaFilled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setContentAreaFilled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setContentAreaFilled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setContentAreaFilled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setContentAreaFilled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setContentAreaFilled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setContentAreaFilled(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setContentAreaFilled(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setContentAreaFilled(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setContentAreaFilled(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setContentAreaFilled(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setContentAreaFilled(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setContentAreaFilled(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setContentAreaFilled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setContentAreaFilled(false);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setContentAreaFilled(false);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        parentesis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/parentesis.png"))); // NOI18N
        parentesis.setContentAreaFilled(false);
        parentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentesisActionPerformed(evt);
            }
        });

        res.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        res.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recursiva.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(parentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(565, 565, 565)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(465, 465, 465)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(564, 564, 564)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(571, 571, 571)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(493, 493, 493)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(parentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(493, 493, 493)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Instancia para volver
        PRINCIPAL2 i = new PRINCIPAL2();
        this.dispose();
        i.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        validar2("sen(");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        validar2("cos(");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        validar2("tan(");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //PARA RESETEAR
        acum = "";
        res.setText("");
        operaciones.setText("");

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        validar3("+");

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (acum.length() != 0) {
            if (validacion2(acum) == false) {
                if (validacion(acum) == false) {
                    acum = acum.substring(0, acum.length() - 1);
                    res.setText(acum);
                }
            }
        }
        if (acum.length() == 0) {
            aparecer("-");
            operaciones.setText("");
        } else {
            aparecer("-");
            operaciones.setText("");
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        validar("9");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        validar("8");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        validar("7");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        //PARA BORRAR
        if (acum != "") {
            String ultimoCaracter = acum.substring(acum.length() - 1);
            if (ultimoCaracter.equals("(")) {
                acum = acum.substring(0, acum.length() - 4);
            } else if (ultimoCaracter.equals("i")) {
                acum = acum.substring(0, acum.length() - 2);
            } else {
                acum = acum.substring(0, acum.length() - 1);
            }

            res.setText(acum);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        validar3("*");

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        validar3("/");

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        validar("6");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        validar("5");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        validar("4");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (caracternumerico(acum)==true){
            validar("*pi");
        }else{
            validar("pi");}
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        validar3("d");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        validar3("%");
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        validar("3");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        validar("2");
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        validar("1");
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        //PARA DAR RESULTADO
        if (p == true) {//validacion de parentesis
            aparecer(")");
            parentesis.setVisible(false);
        }
        String comprobacion = comprobar(acum);
        double resultado = evaluarExpresion(comprobacion);
        if (error == 1) {//validacion de division entre 0
            res.setText(acum);
        } else {
            res.setText(eliminarCero(String.valueOf(resultado)));//resultado al usuario
            acum = eliminarCero(String.valueOf(resultado));//variable resultado
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        validar("0");
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        if (acum.length() == 0) {
            if (acum == "" || caracternumerico(acum) == false && acum.substring(acum.length() - 1) != "i") {
                aparecer("0.");
            } else {
                aparecer(".");
            }
            operaciones.setText("");
        } else if (acum.substring(acum.length() - 1).equals("i") || acum.substring(acum.length() - 1).equals("e")) {
            operaciones.setText("Opcion no valida");
        } else if (acum == "" || caracternumerico(acum) == false && acum.substring(acum.length() - 1) != "i") {
            aparecer("0.");
        } else {
            aparecer(".");
        }

    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        validar3("!");
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        validar3("^");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        if (caracternumerico(acum)==true){
            validar("*e^");
        }else{validar("e^");
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void parentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parentesisActionPerformed
        aparecer(")");
        parentesis.setVisible(false);//visualizacion de parentesis para el usuario
        p = false;
    }//GEN-LAST:event_parentesisActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(recursiva2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recursiva2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recursiva2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recursiva2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recursiva2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel operaciones;
    private javax.swing.JButton parentesis;
    private javax.swing.JLabel res;
    // End of variables declaration//GEN-END:variables
}
