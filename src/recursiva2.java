
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
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
        if (cadena.length()!=0){
        for (int i = 0; i < 10; i++) {
            String i2 = Integer.toString(i);
            if (cadena.substring(cadena.length() - 1).equals(i2)) {
                return c = true;
            }
        }}
        return c;
    }

    //validar si hay parentesis
   public boolean validacion2(String cadena) {
    String ultimoCaracter = cadena.substring(cadena.length() - 1);
    if (ultimoCaracter.equals("(") || ultimoCaracter.equals(")")) {
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
            if (acum.substring(acum.length() - 1).equals("i")||acum.substring(acum.length() - 1).equals("e")) {

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
         setIconImage(new ImageIcon(getClass().getResource("imagenes/liarobot.png")).getImage());
        this.setLocationRelativeTo(null);//centrar ventana
        this.setResizable(false);
        this.setTitle("CALCULADORA RECURSIVA");
        acum = "";

        parentesis.setVisible(false);
        error = 0;
        
         try {
            // Carga la fuente
            InputStream fontStream = getClass().getResourceAsStream("Calculator.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
           Font customFont1 = customFont.deriveFont(Font.PLAIN, 60f); // Tamaño de la fuente
            Font customFont2 = customFont.deriveFont(Font.PLAIN, 40f); // Tamaño de la fuente
            res.setFont(customFont1);
            operaciones.setFont(customFont2);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        CombBTN = new javax.swing.JButton();
        SenBTN = new javax.swing.JButton();
        CosBTN = new javax.swing.JButton();
        TanBTN = new javax.swing.JButton();
        ACBTN = new javax.swing.JButton();
        SumaBTN = new javax.swing.JButton();
        RestaBTN = new javax.swing.JButton();
        BTN9 = new javax.swing.JButton();
        BTN8 = new javax.swing.JButton();
        BTN7 = new javax.swing.JButton();
        BorraUnaBTN = new javax.swing.JButton();
        MultipBTN = new javax.swing.JButton();
        DivisionBTN = new javax.swing.JButton();
        BTN6 = new javax.swing.JButton();
        BTN5 = new javax.swing.JButton();
        BTN4 = new javax.swing.JButton();
        PiBTN = new javax.swing.JButton();
        divBTN = new javax.swing.JButton();
        ModBTN = new javax.swing.JButton();
        BTN3 = new javax.swing.JButton();
        BTN2 = new javax.swing.JButton();
        BTN1 = new javax.swing.JButton();
        igualBTN = new javax.swing.JButton();
        BTN0 = new javax.swing.JButton();
        PuntoBTN = new javax.swing.JButton();
        FactorialBTN = new javax.swing.JButton();
        PotenciaBTN = new javax.swing.JButton();
        EulerBTN = new javax.swing.JButton();
        operaciones = new javax.swing.JLabel();
        parentesis = new javax.swing.JButton();
        res = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));


        CombBTN.setContentAreaFilled(false);

        jButton2.setContentAreaFilled(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 212, 100, 45));


        SenBTN.setContentAreaFilled(false);
        SenBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 100, 50));

        CosBTN.setContentAreaFilled(false);
        CosBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CosBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 213, 97, 50));

        TanBTN.setContentAreaFilled(false);
        TanBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TanBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 208, 96, 55));

        ACBTN.setContentAreaFilled(false);
        ACBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 262, 96, 68));

        SumaBTN.setContentAreaFilled(false);
        SumaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SumaBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 264, 100, 66));

        RestaBTN.setContentAreaFilled(false);
        RestaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestaBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 264, 104, 66));

        BTN9.setContentAreaFilled(false);
        BTN9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 264, 103, 66));

        BTN8.setContentAreaFilled(false);
        BTN8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 261, 92, 70));

        BTN7.setContentAreaFilled(false);
        BTN7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 264, 93, 62));

        BorraUnaBTN.setContentAreaFilled(false);
        BorraUnaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorraUnaBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 335, 90, 78));

        MultipBTN.setContentAreaFilled(false);
        MultipBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultipBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 340, 101, 70));

        DivisionBTN.setContentAreaFilled(false);
        DivisionBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DivisionBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 100, 70));

        BTN6.setContentAreaFilled(false);
        BTN6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 100, 70));

        BTN5.setContentAreaFilled(false);
        BTN5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 90, 70));

        BTN4.setContentAreaFilled(false);
        BTN4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 336, 89, 76));

        PiBTN.setContentAreaFilled(false);
        PiBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 90, 70));

        divBTN.setContentAreaFilled(false);
        divBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 420, 100, 70));

        ModBTN.setContentAreaFilled(false);
        ModBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 420, 100, 60));

        BTN3.setContentAreaFilled(false);
        BTN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 423, 100, 60));

        BTN2.setContentAreaFilled(false);
        BTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 90, 60));

        BTN1.setContentAreaFilled(false);
        BTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 418, 98, 70));

        igualBTN.setContentAreaFilled(false);
        igualBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                igualBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 491, 96, 73));

        BTN0.setContentAreaFilled(false);
        BTN0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN0ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 493, 90, 70));

        PuntoBTN.setContentAreaFilled(false);
        PuntoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuntoBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 493, 100, 70));

        FactorialBTN.setContentAreaFilled(false);
        FactorialBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FactorialBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 100, 70));

        PotenciaBTN.setContentAreaFilled(false);
        PotenciaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PotenciaBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 100, 70));

        EulerBTN.setContentAreaFilled(false);
        EulerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EulerBTNActionPerformed(evt);
            }
        });
        jPanel1.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 90, 70));
        jPanel1.add(operaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 540, 50));

        parentesis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/parentesis.png"))); // NOI18N
        parentesis.setContentAreaFilled(false);
        parentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentesisActionPerformed(evt);
            }
        });
        jPanel1.add(parentesis, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 40, 50));

        res.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        res.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 670, 50));

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
                .addComponent(CombBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(SumaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(BTN9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(BTN7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(MultipBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(DivisionBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(BTN5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(BTN3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(BTN2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(PotenciaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(FactorialBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(igualBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(BTN0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(EulerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(ModBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(parentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(565, 565, 565)
                .addComponent(TanBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(BTN6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ACBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(BTN8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(465, 465, 465)
                .addComponent(CosBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(RestaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(564, 564, 564)
                .addComponent(BTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(SenBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(divBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(BorraUnaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(PiBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(571, 571, 571)
                .addComponent(BTN4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(PuntoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(CombBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SumaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MultipBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DivisionBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(BTN3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BTN2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PotenciaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FactorialBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(igualBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(493, 493, 493)
                .addComponent(BTN0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(EulerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(ModBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(parentesis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(TanBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(BTN6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(ACBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(BTN8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(CosBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(RestaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(BTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(SenBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(divBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(BorraUnaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(PiBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(BTN4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(493, 493, 493)
                .addComponent(PuntoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonescalc.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));


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

    private void SenBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenBTNActionPerformed
        validar2("sen(");
    }//GEN-LAST:event_SenBTNActionPerformed

    private void CosBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CosBTNActionPerformed
        validar2("cos(");
    }//GEN-LAST:event_CosBTNActionPerformed

    private void TanBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TanBTNActionPerformed
        validar2("tan(");
    }//GEN-LAST:event_TanBTNActionPerformed

    private void ACBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACBTNActionPerformed
        //PARA RESETEAR
        acum = "";
        res.setText("");
        operaciones.setText("");

    }//GEN-LAST:event_ACBTNActionPerformed

    private void SumaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SumaBTNActionPerformed
        validar3("+");

    }//GEN-LAST:event_SumaBTNActionPerformed

    private void RestaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestaBTNActionPerformed
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

    }//GEN-LAST:event_RestaBTNActionPerformed

    private void BTN9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN9ActionPerformed
        validar("9");
    }//GEN-LAST:event_BTN9ActionPerformed

    private void BTN8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN8ActionPerformed
        validar("8");
    }//GEN-LAST:event_BTN8ActionPerformed

    private void BTN7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN7ActionPerformed
        validar("7");
    }//GEN-LAST:event_BTN7ActionPerformed

    private void BorraUnaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorraUnaBTNActionPerformed
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
    }//GEN-LAST:event_BorraUnaBTNActionPerformed

    private void MultipBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultipBTNActionPerformed
        validar3("*");

    }//GEN-LAST:event_MultipBTNActionPerformed

    private void DivisionBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DivisionBTNActionPerformed
        validar3("/");

    }//GEN-LAST:event_DivisionBTNActionPerformed

    private void BTN6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN6ActionPerformed
        validar("6");
    }//GEN-LAST:event_BTN6ActionPerformed

    private void BTN5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN5ActionPerformed
        validar("5");
    }//GEN-LAST:event_BTN5ActionPerformed

    private void BTN4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN4ActionPerformed
        validar("4");
    }//GEN-LAST:event_BTN4ActionPerformed

    private void PiBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiBTNActionPerformed
        if (caracternumerico(acum)==true){
            validar("*pi");
        }else{
            validar("pi");}
    }//GEN-LAST:event_PiBTNActionPerformed

    private void divBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divBTNActionPerformed
        validar3("d");
    }//GEN-LAST:event_divBTNActionPerformed

    private void ModBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModBTNActionPerformed
        validar3("%");
    }//GEN-LAST:event_ModBTNActionPerformed

    private void BTN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN3ActionPerformed
        validar("3");
    }//GEN-LAST:event_BTN3ActionPerformed

    private void BTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN2ActionPerformed
        validar("2");
    }//GEN-LAST:event_BTN2ActionPerformed

    private void BTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN1ActionPerformed
        validar("1");
    }//GEN-LAST:event_BTN1ActionPerformed

    private void igualBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_igualBTNActionPerformed
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
    }//GEN-LAST:event_igualBTNActionPerformed

    private void BTN0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN0ActionPerformed
        validar("0");
    }//GEN-LAST:event_BTN0ActionPerformed

    private void PuntoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuntoBTNActionPerformed
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

    }//GEN-LAST:event_PuntoBTNActionPerformed

    private void FactorialBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FactorialBTNActionPerformed
        validar3("!");
    }//GEN-LAST:event_FactorialBTNActionPerformed

    private void PotenciaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PotenciaBTNActionPerformed
        validar3("^");
    }//GEN-LAST:event_PotenciaBTNActionPerformed

    private void EulerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EulerBTNActionPerformed
        if (caracternumerico(acum)==true){
            validar("*e^");
        }else{validar("e^");
        }
    }//GEN-LAST:event_EulerBTNActionPerformed

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
    private javax.swing.JButton ACBTN;
    private javax.swing.JButton BTN0;
    private javax.swing.JButton BTN1;
    private javax.swing.JButton BTN2;
    private javax.swing.JButton BTN3;
    private javax.swing.JButton BTN4;
    private javax.swing.JButton BTN5;
    private javax.swing.JButton BTN6;
    private javax.swing.JButton BTN7;
    private javax.swing.JButton BTN8;
    private javax.swing.JButton BTN9;
    private javax.swing.JButton BorraUnaBTN;
    private javax.swing.JButton CombBTN;
    private javax.swing.JButton CosBTN;
    private javax.swing.JButton DivisionBTN;
    private javax.swing.JButton EulerBTN;
    private javax.swing.JButton FactorialBTN;
    private javax.swing.JButton ModBTN;
    private javax.swing.JButton MultipBTN;
    private javax.swing.JButton PiBTN;
    private javax.swing.JButton PotenciaBTN;
    private javax.swing.JButton PuntoBTN;
    private javax.swing.JButton RestaBTN;
    private javax.swing.JButton SenBTN;
    private javax.swing.JButton SumaBTN;
    private javax.swing.JButton TanBTN;
    private javax.swing.JButton divBTN;
    private javax.swing.JButton igualBTN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel operaciones;
    private javax.swing.JButton parentesis;
    private javax.swing.JLabel res;
    // End of variables declaration//GEN-END:variables
}
