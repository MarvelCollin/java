package main;

import java.util.ArrayList;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Mahasiswa mahasiswa1 = new Mahasiswa("Nadine", 19);
		Mahasiswa mahasiswa2 = new Mahasiswa("Botak", 18);
		Mahasiswa mahasiswa3 = new Mahasiswa("Helena", 19);
		Mahasiswa mahasiswa4 = new Mahasiswa("Celine", 20);
		//Array
		//Tipe[] nama = new Tipe[size]
		Object[] data = new Object[4];
		data[0]=mahasiswa1
		data[1]=mahasiswa2;
		data[2]=mahasiswa3;
		data[3]=mahasiswa4;
		System.out.println(((Mahasiswa) data[0]).getNama());
		//ArrayList
		//ArrayList<Tipe> nama= new ArrayList<>();
		ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<Mahasiswa>();
		dataMahasiswa.add(mahasiswa1);
		dataMahasiswa.add(mahasiswa2);
		dataMahasiswa.add(mahasiswa3);
		dataMahasiswa.add(mahasiswa4);
		System.out.println(dataMahasiswa.get(0).getNama());
		mahasiswa1.setUmur(15);
		
	}

}
