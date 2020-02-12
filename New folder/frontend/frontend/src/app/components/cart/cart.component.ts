import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';
import { AddressService } from 'src/app/services/address.service';
import { Alert } from 'src/app/models/alert';
import { OrderDetails } from 'src/app/models/order-details';
import { Registration } from 'src/app/models/registration';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { OrderService } from 'src/app/services/order.service';
import { OrderItem } from 'src/app/models/order-item';
import {Addressinfo} from 'src/app/auth/addressinfo';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  form: any = {};  
  address: Addressinfo;

  dafualtQuantity:number=1;
  productAddedTocart:Product[];
  allTotal:number;

  currentUser: Registration[];
  orderDetail:OrderDetails;
  orderItem:OrderItem[];
  
  public globalResponse: any;
  public alerts: Array<Alert> = [];

  deliveryForm:FormGroup;

  totalSum: number = 0;

  constructor(private productService:ProductService,private fb: FormBuilder,private authService:AuthenticationService,private orderService:OrderService,private addS:AddressService) 
  {
     
   }

  ngOnInit() {
    this.productAddedTocart=this.productService.getProductFromCart();
    for (let i in this.productAddedTocart) {
      this.productAddedTocart[i].Quantity=1;
   }
   this.productService.removeAllProductFromCart();
   this.productService.addProductToCart(this.productAddedTocart);
   this.calculteAllTotal(this.productAddedTocart);

   this.productAddedTocart.forEach(value => {
   this.totalSum = this.totalSum + (value.Quantity * value.UnitPrice);
  });
}
calculteAllTotal(allItems:Product[])
{
  var total=0;
  for (let i in allItems) {
    total= total+(allItems[i].Quantity * allItems[i].UnitPrice);
 }
 this.allTotal=total;



 this.deliveryForm = this.fb.group({
  UserName:  ['', [Validators.required]],
  DeliveryAddress:['',[Validators.required]],
  Phone:['',[Validators.required]],
  Email:['',[Validators.required]],
  Message:['',[]],
  Amount:['',[Validators.required]],

});


}



onAddQuantity(product:Product)
  {
    //Get Product
  this.productAddedTocart=this.productService.getProductFromCart();
  this.productAddedTocart.find(p=>p.id==product.id).Quantity = product.Quantity+1;
  this.productService.removeAllProductFromCart();
  this.productService.addProductToCart(this.productAddedTocart);
  this.calculteAllTotal(this.productAddedTocart);
  this.deliveryForm.controls["Amount"].setValue(this.allTotal);
   
  }
  onRemoveQuantity(product:Product)
  {
    this.productAddedTocart=this.productService.getProductFromCart();
    this.productAddedTocart.find(p=>p.id==product.id).Quantity = product.Quantity-1;
    this.productService.removeAllProductFromCart();
    this.productService.addProductToCart(this.productAddedTocart);
    this.calculteAllTotal(this.productAddedTocart);
    this.deliveryForm.controls['Amount'].setValue(this.allTotal);

  }

 
  onSubmit()
  {

    this.address=new Addressinfo(
      this.form.PostalCode,
      this.form.StreetAddress,
      this.form.City,
      this.form.Province,


    );
   // const formData = new FormData();
//formData.append('address',JSON.stringify(this.address));
this.addS.addAddress(this.address).subscribe((response) => {
  console.log(response);
  }
  
  )

  }


}
  









