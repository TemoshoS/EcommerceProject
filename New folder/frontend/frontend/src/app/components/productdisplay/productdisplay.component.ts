import { Component, OnInit } from '@angular/core';
import { ProductDisplay } from 'src/app/models/product-display';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/models/product';
import { Alert } from 'src/app/models/alert';
import { SharedService } from 'src/app/services/shared.service';
import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';




@Component({
  selector: 'app-productdisplay',
  templateUrl: './productdisplay.component.html',
  styleUrls: ['./productdisplay.component.css']
})
export class ProductdisplayComponent implements OnInit {

  public alerts: Array<Alert> = [];
  cartItemCount: number = 0;
  @Output() cartEvent = new EventEmitter<number>();
  public globalResponse: any;
  yourByteArray:any;
  allProducts: ProductDisplay[];
  productAddedTocart:Product[];
  searchText;
  
  constructor(private productService:ProductService,private sharedService:SharedService, private sanitizer: DomSanitizer) { }


  
  ngOnInit() {
    this.productService.getAllProducts()
            .subscribe((result) => {
              this.globalResponse = result;  
              console.log(result);   
                       
            },
            error => { 
              console.log(error.message);
            },
            () => {
                
                console.log("Product fetched sucssesfully.");
                this.allProducts=this.globalResponse;
                
                }
              )

       

 }
 OnAddCart(product:Product)
 {
  this.productAddedTocart=[];
  this.productAddedTocart.push(product);
  this.productService.addProductToCart(this.productAddedTocart);
  this.alerts.push({
    id: 1,
    type: 'success',
    message: 'Product added to cart.'
  });


  this.cartItemCount=this.productAddedTocart.length;
  
  this.sharedService.updateCartCount(this.cartItemCount);

  
 }

 public closeAlert(alert: Alert) {
  const index: number = this.alerts.indexOf(alert);
  this.alerts.splice(index, 1);
 }



//delete product

deleteProduct(Id: number) {
  this.productService.deleteProduct(Id)
    .subscribe(
      data => {
        console.log(data);
        
      },
      error => console.log(error));
} 
}
