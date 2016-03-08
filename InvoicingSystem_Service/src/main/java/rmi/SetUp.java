package rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.accountdata.accountdata;
import data.billmanegementdata.BillDataController;
import data.commoditydata.CommodityData;
import data.kinddata.KindData;
import data.loginData.LoginData;
import data.marketdata.MarketDataControl;
import data.memberdata.MemberDataControl;
import data.promotiondata.TotalCouponDataController;
import data.promotiondata.TotalGiftDataController;
import data.promotiondata.TotalMethodDataController;
import data.promotiondata.VipCouponDataController;
import data.promotiondata.VipDiscountDataController;
import data.promotiondata.VipGiftDataController;
import data.promotiondata.VipMethodDataController;
import data.paymentdata.paymentcashdata;
import data.paymentdata.paymentindata;
import data.paymentdata.paymentoutdata;
import data.userdata.UserData;
import dataservice.accountdataservice.accountdataservice;
import dataservice.billmanagementdataservice.BillManagementDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.kinddataservice.KindDataService;
import dataservice.loginDataService.LoginDataService;
import dataservice.marketdataservice.MarketDataService;
import dataservice.memberdataservice.MemberDataService;
import dataservice.promotiondataservice.TotalCouponPromotionDataService;
import dataservice.promotiondataservice.TotalGiftPromotionDataService;
import dataservice.promotiondataservice.TotalPromotionMethodDataService;
import dataservice.promotiondataservice.VipCouponPromotionDataService;
import dataservice.promotiondataservice.VipDiscountPromotionDataService;
import dataservice.promotiondataservice.VipGiftPromotionDataService;
import dataservice.promotiondataservice.VipPromotionMethodDataService;
import dataservice.paymentdataservice.paymentcashdataservice;
import dataservice.paymentdataservice.paymentindataservice;
import dataservice.paymentdataservice.paymentoutdataservice;
import dataservice.userdataservice.UserDataService;


public class SetUp {
	
	
	
	public static void main(String[] args){
		String ip=null;
		
		try {
			ip=InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(ip);
		 try { 
	            //创建一个远程对象 
	            MemberDataService rmem = new MemberDataControl(); 
	            MarketDataService mark = new MarketDataControl();
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(8888); 

	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            Naming.bind("rmi://"+ip+":8888/MemberData",rmem); 
	            Naming.bind("rmi://"+ip+":8888/MarketData", mark);
	            System.out.println(">>>>>INFO:远程MemberData对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 try { 
	            //创建一个远程对象 
	            accountdataservice ac = new accountdata(); 
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(8811); 

	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            Naming.bind("rmi://"+ip+":8811/accountdata",ac); 

	            System.out.println(">>>>>INFO:远程accountdata对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 try { 
	            //创建一个远程对象 
	            CommodityDataService comdData=new CommodityData();
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(8028); 

	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            System.out.println("comdData创建完成");
	            Naming.bind("rmi://"+ip+":8028/comdData",comdData); 

	            System.out.println(">>>>>INFO:远程CommodityData对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 try { 
	            //创建一个远程对象 
	            paymentindataservice ac = new paymentindata(); 
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(8812); 

	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            Naming.bind("rmi://"+ip+":8812/payindata",ac); 

	            System.out.println(">>>>>INFO:远程payindata对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 try { 
	            //创建一个远程对象 
	            paymentoutdataservice ac = new paymentoutdata(); 
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(8813); 

	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            Naming.bind("rmi://"+ip+":8813/payoutdata",ac); 

	            System.out.println(">>>>>INFO:远程payoutdata对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 try { 
	            //创建一个远程对象 
	            paymentcashdataservice ac = new paymentcashdata(); 
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(8822); 

	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            Naming.bind("rmi://"+ip+":8822/paycashdata",ac); 

	            System.out.println(">>>>>INFO:远程paycashdata对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 
		 try { 
	            //创建一个远程对象 
	            KindDataService kc = new KindData(); 
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(1103); 

	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            Naming.bind("rmi://"+ip+":1103/kindData",kc); 

	            System.out.println(">>>>>INFO:远程kinddata对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 
		 try { 
	            //创建一个远程对象 
	            TotalCouponPromotionDataService tcp=new TotalCouponDataController();
	            TotalGiftPromotionDataService tgp=new TotalGiftDataController();
	            TotalPromotionMethodDataService  tpm=new TotalMethodDataController();
	            
	            VipCouponPromotionDataService vcp=new VipCouponDataController();
	            VipGiftPromotionDataService vgp=new VipGiftDataController();
	            VipPromotionMethodDataService  vpm=new VipMethodDataController();
	            VipDiscountPromotionDataService vdp=new VipDiscountDataController();
	            
	            BillManagementDataService bmd=new BillDataController();
	            
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8808，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(8808); 

	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            Naming.bind("rmi://"+ip+":8808/TotalCouponData",tcp);
	            Naming.bind("rmi://"+ip+":8808/TotalGiftData",tgp);
	            Naming.bind("rmi://"+ip+":8808/TotalMethodData",tpm);
	            
	            Naming.bind("rmi://"+ip+":8808/VipCouponData",vcp);
	            Naming.bind("rmi://"+ip+":8808/VipGiftData",vgp);
	            Naming.bind("rmi://"+ip+":8808/VipMethodData",vpm);
	            Naming.bind("rmi://"+ip+":8808/VipDiscountData",vdp);
	            
	            Naming.bind("rmi://"+ip+":8808/BillData",bmd);
	            
	            System.out.println(">>>>>INFO:远程Data对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("Promotion创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 
		 try { 
	            //创建一个远程对象 
			   LoginDataService lds = new LoginData(); 
	           UserDataService uds=new UserData();
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(4028); 
	            LocateRegistry.createRegistry(4029); 
	            //把远程对象注册到RMI注册服务器上，并命名为MemberData 
	            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
	            Naming.bind("rmi://"+ip+":4028/loginData",lds);
	            Naming.bind("rmi://"+ip+":4029/userData", uds);
	            System.out.println(">>>>>INFO:远程LoginData对象绑定成功！"); 
	            System.out.println(">>>>>INFO:远程UserData对象绑定成功！"); 
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        }
		 
	}

}
