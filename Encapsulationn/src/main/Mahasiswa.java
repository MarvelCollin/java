package main;

public class Mahasiswa {
	private String nama;
	private int umur;

	// Public, private, default,protected
	public Mahasiswa(String nama, int umur) {
		super();
		this.nama = nama;
		this.umur = umur;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getUmur() {
		return umur;
	}

	public void setUmur(int umur) {
		if (umur < 17) {
			System.out.println("Maaf, umur anda tidak mencukupi");
		} else {
			this.umur = umur;
		}
	}

}
