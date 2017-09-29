import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MaasHesaplamasi {
	
//�X liral�k net maa� i�in ne kadarl�k br�t maa� gerekir?
	
	double Kesintiler;
	double Vergiler;
	double NetMaas;
	double Br�tMaas;
	long counter=0;
	
	ArrayList<Double>NetMaaslar= new ArrayList<>();
	
	double[][] netMaasTahminAral���= new double[1][2];
	
	public double NetMaasHesapla(double br�tMaas){
		Kesintiler=br�tMaas*0.1;
		Vergiler=br�tMaas*0.2;
		NetMaas=br�tMaas-(Kesintiler+Vergiler);
		return  NetMaas;
	}
	
	public double Br�tMaasHesapla(double netMaas){
		counter++;
		NetMaaslar.add(netMaas);
		double aral�k=netMaas-netMaas*0.1;
		
		if(counter==1){
		
			netMaasTahminAral���[0][0]=NetMaaslar.get(0);
			netMaasTahminAral���[0][1]=aral�k;
		}
		Br�tMaas=netMaas*(1.5);
		double tahminNetMaas=NetMaasHesapla(Br�tMaas);
		
		if(tahminNetMaas>NetMaaslar.get(0)){
			
			if(counter>1){
				netMaasTahminAral���[0][0]=NetMaaslar.get((int)counter-1);
			}
			netMaas=ThreadLocalRandom.current().nextDouble(netMaasTahminAral���[0][1],netMaasTahminAral���[0][0]);
			return Br�tMaasHesapla(netMaas);
			
		}else if(tahminNetMaas<NetMaaslar.get(0)){
				netMaasTahminAral���[0][1]=NetMaaslar.get((int)counter-1);
				netMaas=ThreadLocalRandom.current().nextDouble(netMaasTahminAral���[0][1],netMaasTahminAral���[0][0]);
				return Br�tMaasHesapla(netMaas);
				}
		
		return Br�tMaas;
	
	}
	
	public static void main(String[] args) {
		
		MaasHesaplamasi maasHesaplamasi = new MaasHesaplamasi();
		
		System.out.println(maasHesaplamasi.Br�tMaasHesapla(5.000));
	
	
	}

}
