import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MaasHesaplamasi {
	
//“X liralýk net maaþ için ne kadarlýk brüt maaþ gerekir?
	
	double Kesintiler;
	double Vergiler;
	double NetMaas;
	double BrütMaas;
	long counter=0;
	
	ArrayList<Double>NetMaaslar= new ArrayList<>();
	
	double[][] netMaasTahminAralýðý= new double[1][2];
	
	public double NetMaasHesapla(double brütMaas){
		Kesintiler=brütMaas*0.1;
		Vergiler=brütMaas*0.2;
		NetMaas=brütMaas-(Kesintiler+Vergiler);
		return  NetMaas;
	}
	
	public double BrütMaasHesapla(double netMaas){
		counter++;
		NetMaaslar.add(netMaas);
		double aralýk=netMaas-netMaas*0.1;
		
		if(counter==1){
		
			netMaasTahminAralýðý[0][0]=NetMaaslar.get(0);
			netMaasTahminAralýðý[0][1]=aralýk;
		}
		BrütMaas=netMaas*(1.5);
		double tahminNetMaas=NetMaasHesapla(BrütMaas);
		
		if(tahminNetMaas>NetMaaslar.get(0)){
			
			if(counter>1){
				netMaasTahminAralýðý[0][0]=NetMaaslar.get((int)counter-1);
			}
			netMaas=ThreadLocalRandom.current().nextDouble(netMaasTahminAralýðý[0][1],netMaasTahminAralýðý[0][0]);
			return BrütMaasHesapla(netMaas);
			
		}else if(tahminNetMaas<NetMaaslar.get(0)){
				netMaasTahminAralýðý[0][1]=NetMaaslar.get((int)counter-1);
				netMaas=ThreadLocalRandom.current().nextDouble(netMaasTahminAralýðý[0][1],netMaasTahminAralýðý[0][0]);
				return BrütMaasHesapla(netMaas);
				}
		
		return BrütMaas;
	
	}
	
	public static void main(String[] args) {
		
		MaasHesaplamasi maasHesaplamasi = new MaasHesaplamasi();
		
		System.out.println(maasHesaplamasi.BrütMaasHesapla(5.000));
	
	
	}

}
