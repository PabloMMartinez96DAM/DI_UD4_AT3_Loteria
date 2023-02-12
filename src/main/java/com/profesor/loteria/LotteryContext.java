package com.profesor.loteria;

public final class LotteryContext {

    //Properties
    private static LotteryContext instance;


    //Número de la lotería con el formato correcto
    private String lotteryNumber;



    public static LotteryContext getInstance() {

        if(instance == null){
            instance = new LotteryContext();
        }
        return instance;
    }


    public String getLotteryNumber() {
        return lotteryNumber;
    }

    public void setLotteryNumber(String lotteryNumber) {

        //Obtengo los números en formato entero para poder formatearlos
        int numbers = Integer.parseInt(lotteryNumber);

        //Formateo los números indicando que me rellene con el caracter '0' hasta que sean 5 elementos
        this.lotteryNumber = String.format("%05d",numbers);
    }
}
