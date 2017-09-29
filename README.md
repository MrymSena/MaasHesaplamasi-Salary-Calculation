# MaasHesaplamasi-Salary-Calculation
Maas Hesaplama (Recursive Metod)

Problem:
Maaş Hesaplaması
 

Bir çalışanın maaşı içerisinde devlete verilen vergiler ve çeşitli kesintiler bulunmaktadır. Tüm kesinti ve vergilerin de içerisinde bulunduğu tutara brüt maaş, çalışanın eline geçen paraya ise net maaş denmektedir.

brüt maaş = net maaş + kesintiler + vergiler

Devlet brüt maaşı belli olan bir personel için net maaş hesaplamasının ne şekilde olacağını belirtmiştir. Çok basit bir örnek olarak,

kesintiler = brüt maaş * 0.1

vergiler = brüt maaş * 0.2

Şeklinde bir formül ile brüt maaşı belli bir personelin net maaşının ne kadar olduğu hesaplanabilmektedir.

Kesinti ve vergilerin hesaplaması gerçekte karmaşık formüllere ve değişkenlere bağlı olduğu için, net maaşı belli personelin brüt maaşının hesaplanması formüle edilememektedir. Dolayısıyla net maaşı belli personelin brüt maaşını bulabilmek için brütten net maaş hesaplayan formül kullanılmalıdır. Dolayısıyla, “X liralık net maaş için ne kadarlık brüt maaş gerekir?” sorusunun cevabı için önce tahmini bir brüt tutar kullanılıp bunun neti hesaplanmalı, aradaki farka göre tahminler devam etmelidir.

Elinizde

double NetMaaşHesapla(double brütMaaş)

şeklinde, brüt maaş alıp net maaş dönen bir metodunuz olduğunu varsayın. 

Bu metodu kullanan ve recursive (özyineli) olan, net maaşı alıp bundan brüt maaşı hesaplayan bir metod yazın.

Not: Ortalama olarak X tutarındaki bir net maaşın 1.5X civarında brüt tutarı olduğunu varsayıp tahminlerinizi ona göre yaptırabilirsiniz.
