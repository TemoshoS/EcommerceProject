import { Component, OnInit,Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';
import { Alert } from 'src/app/models/alert';
import { Producdto } from 'src/app/auth/producdto';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  productForm:any = FormGroup;
  public userFile: any = File;
  user: Producdto;
  form: any = {};  
  showAdd = false;
  
  @Input()
  public alerts: Array<Alert> = [];
  public globalResponse: any;
  

  constructor(private fb: FormBuilder,private authService:AuthenticationService,private productService:ProductService) { }

  ngOnInit() {
    
  
  }

  
  ///////////////////////////////////
  handleImageFile(event)
  {
    const file = event.target.files[0];
    this.userFile =file;
  }
  ////////////////////////////

  onSubmit()
  {

    this.user=new Producdto(
      this.form.prodname,
      this.form.proddecription,
      this.form.prodprice,
      this.form.category,
      this.form.prodquantity,
    );
    const formData = new FormData();
formData.append('user',JSON.stringify(this.user));
formData.append('file',this.userFile);
this.productService.saveProduct(formData).subscribe((response) => {
  console.log(response);
  }
  
  )

  }
  
}
