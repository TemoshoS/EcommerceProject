export class Addressinfo {

    PostalCode: string;
    StreetAddress: string;
    City: string;
    Province: string;
   
 
    constructor(PostalCode: string, StreetAddress: string, City: string, Province: string) {
        this.PostalCode = PostalCode;
        this.StreetAddress = StreetAddress;
        this.City = City;
        this.Province = Province;
      
    }

}
