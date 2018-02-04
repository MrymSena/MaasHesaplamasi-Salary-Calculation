import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MaasHesaplamasi {
	
//�X liral�k net maa� i�in ne kadarl�k br�t maa� gerekir?
	
	double kesintiler;
	double vergiler;
	double netMaas;
	double br�tMaas;
	long counter=0;
	
	ArrayList<Double>netMaaslar= new ArrayList<>();
	
	double[][] netMaasTahminAral���= new double[1][2];
	
	public double netMaasHesapla(double br�tMaas){
		kesintiler=br�tMaas*0.1;
		vergiler=br�tMaas*0.2;
		netMaas=br�tMaas-(kesintiler+vergiler);
		return  netMaas;
	}
	
	public double br�tMaasHesapla(double netMaas){
		counter++;
		netMaaslar.add(netMaas);
		double aral�k=netMaas-netMaas*0.1;
		
		if(counter==1){
		
			netMaasTahminAral���[0][0]=netMaaslar.get(0);
			netMaasTahminAral���[0][1]=aral�k;
		}
		br�tMaas=netMaas*(1.5);
		double tahminNetMaas=netMaasHesapla(br�tMaas);
		
		if(tahminNetMaas>netMaaslar.get(0)){
			
			if(counter>1){
				netMaasTahminAral���[0][0]=netMaaslar.get((int)counter-1);
			}
			netMaas=ThreadLocalRandom.current().nextDouble(netMaasTahminAral���[0][1],netMaasTahminAral���[0][0]);
			return br�tMaasHesapla(netMaas);
			
		}else if(tahminNetMaas<netMaaslar.get(0)){
				netMaasTahminAral���[0][1]=netMaaslar.get((int)counter-1);
				netMaas=ThreadLocalRandom.current().nextDouble(netMaasTahminAral���[0][1],netMaasTahminAral���[0][0]);
				return br�tMaasHesapla(netMaas);
				}
		
		return br�tMaas;
	
	}
	
	public static void main(String[] args) {
		
		MaasHesaplamasi maasHesaplamasi = new MaasHesaplamasi();
		
		System.out.println(maasHesaplamasi.br�tMaasHesapla(5.000));
	
	
	}

}
