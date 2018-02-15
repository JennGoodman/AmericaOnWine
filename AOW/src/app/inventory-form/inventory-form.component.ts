import { Component, OnInit, Input } from '@angular/core';
import { Country } from '../../models/Country';
import { Type } from '../../models/Type';
import { SubType } from '../../models/SubType';
import { CountryService } from '../../services/country.service';
import { TypeService } from '../../services/type.service';
import { SubTypeService } from '../../services/sub-type.service';
import { Inventory } from '../../models/Inventory';
import { BrandService } from '../../services/brand.service';
import { Brand } from '../../models/Brand';
import { FileUploadService } from '../../services/file-upload.service';
import { InventoryService } from '../../services/inventory.service';

@Component({
  selector: 'app-inventory-form',
  templateUrl: './inventory-form.component.html',
  styleUrls: ['./inventory-form.component.css']
})
export class InventoryFormComponent implements OnInit {
  invItem: Inventory;
  typeList: Type[] = [];
  redSubtypeList: SubType[] = [];
  whiteSubtypeList: SubType[] = [];
  roseSubtypeList: SubType[] = [];
  champSubtypeList: SubType[] = [];
  countryList: Country[] = [];
  brandList: Brand[] = [];
  curType = 'def';
  brandChanged = false;
  countryChanged = false;
  typeChanged = false;
  curSubType: string = null;
  curCountry: string = null;
  curBrand: string = null;


  constructor(private countries: CountryService, private types: TypeService, private subtypes: SubTypeService,
     private brands: BrandService, private fileService: FileUploadService, private invService: InventoryService) {

    this.countries.getAll().subscribe(items => {
      this.countryList = items;
      console.log(items);
    });

    this.types.getAll().subscribe(items => {
      this.typeList = items;
      console.log(items);
    });

    this.brands.getAll().subscribe(items => {
      this.brandList = items;
      console.log(items);
    });

    this.subtypes.getAll().subscribe(items => {
      const stl = items;
      console.log(stl);
      this.redSubtypeList = stl.filter((sub) => {
        return sub.type.name === 'Red';
      });
      this.whiteSubtypeList = stl.filter((sub) => {
        return sub.type.name === 'White';
      });
      this.roseSubtypeList = stl.filter((sub) => {
        return sub.type.name === 'Rosé';
      });
      this.champSubtypeList = stl.filter((sub) => {
        return sub.type.name === 'Champagne';
      });

    });
    this.invItem = JSON.parse(localStorage.getItem("invItemClicked"));
      if (this.invItem)
      {
          document.onreadystatechange = () =>
          {
              if(document.readyState === 'complete')
              {
                  let img = <HTMLInputElement> document.getElementById('img-input');
                  img.parentNode.parentNode.removeChild(img.parentNode);
                  let submit = <HTMLButtonElement> document.getElementById('submitButton');
                  submit.click = () =>
                  {
                      this.invService.update(this.invItem).subscribe(
                          resp =>
                          {
                            console.log(resp as Inventory);
                          });
                  }
              }

          }
      }
      else
      {
        this.invItem = new Inventory;
      }
   }

   resetType() {
     this.invItem.subType = null;
     this.typeChanged = false;
     console.log(this.curType);
   }

   changeBrand() {
     this.brandChanged = true;
   }

   changeCountry() {
     this.countryChanged = true;
   }

   changeType() {
     this.typeChanged = true;
   }

   addWine() {
     this.invItem.id = 0;
     this.invItem.userId = JSON.parse(localStorage.getItem('user')).id;
     console.log(this.invItem.userId);
     this.invItem.submitted = new Date();

    this.invItem.brand = this.brandList.filter((item) => {
       return this.curBrand === item.name;
     })[0];

    this.invItem.country = this.countryList.filter((item) => {
      return this.curCountry === item.name;
    })[0];

    if (this.curType === 'Red') {
      this.invItem.subType = this.redSubtypeList.filter((item) => {
        return this.curSubType === item.name;
      })[0];
    }  else if (this.curType === 'White') {
      this.invItem.subType = this.whiteSubtypeList.filter((item) => {
        return this.curSubType === item.name;
      })[0];
    } else if (this.curType === 'Rosé') {
      this.invItem.subType = this.roseSubtypeList.filter((item) => {
        return this.curSubType === item.name;
      })[0];
    } else if (this.curType === 'Champagne') {
      this.invItem.subType = this.champSubtypeList.filter((item) => {
        return this.curSubType === item.name;
      })[0];
    }

     const img = <HTMLInputElement> document.getElementById('img-input');
     this.invItem.imageUrl = 'https://americaonwine.s3.amazonaws.com/' + (img.files[0] ? img.files[0].name : '');

     let nulled = false;
     for (const i in this.invItem) {
       if (this.invItem[i] === null) {
         nulled = true;
         break;
       }
     }

     if (nulled) {
       console.log('SOMETHING WAS NULL!');
     } else {
      this.fileService.uploadFile(img.files[0]);
      this.invService.add(this.invItem).subscribe(item => {
        console.log(item);
      });
     }
   }

  ngOnInit() {
  }

}
