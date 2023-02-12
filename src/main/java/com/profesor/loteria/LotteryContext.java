package com.profesor.loteria;

public final class LotteryContext {

    //Properties


    //Instancia de la propia clase LotteryContext
    private static LotteryContext instance;


    //Número de la lotería obtenido del MainViewController
    private String lotteryNumber;

    //Método para obtener la instancia actual y crear una en caso de que no se haya invocado nunca
    public static LotteryContext getInstance() {

        if(instance == null){
            instance = new LotteryContext();
        }
        return instance;
    }

    //Getters & Setters
    public String getLotteryNumber() {
        return lotteryNumber;
    }

    //Recibe el número de lotería del usuario y lo formatea para su uso en el BoletoController
    public void setLotteryNumber(String lotteryNumber) {
        //Obtengo los números en formato entero para poder formatearlos
        int numbers = Integer.parseInt(lotteryNumber);

        //Formateo los números indicando que me rellene con el caracter '0' hasta que sean 5 elementos
        this.lotteryNumber = String.format("%05d",numbers);
    }
}
