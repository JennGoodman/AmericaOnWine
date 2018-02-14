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


  constructor(private countries: CountryService, private types: TypeService, private subtypes: SubTypeService,
     private brands: BrandService, private fileService: FileUploadService, private invService: InventoryService) {
    this.invItem = new Inventory;

    this.countries.getAll().subscribe(items => {
      this.countryList = items;
    });

    this.types.getAll().subscribe(items => {
      this.typeList = items;
    });

    this.brands.getAll().subscribe(items => {
      this.brandList = items;
    });

    this.subtypes.getAll().subscribe(items => {
      const stl = items;
      this.redSubtypeList = stl.filter((sub) => {
        return sub.type.type === 'Red';
      });
      this.whiteSubtypeList = stl.filter((sub) => {
        return sub.type.type === 'White';
      });
      this.roseSubtypeList = stl.filter((sub) => {
        return sub.type.type === 'Rosé';
      });
      this.champSubtypeList = stl.filter((sub) => {
        return sub.type.type === 'Champagne';
      });

    });
   }

   resetType() {
     this.invItem.subType = null;
     this.typeChanged = false;
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
     this.invItem.user = JSON.parse(localStorage.getItem('user'));
     this.invItem.submitted = new Date();
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
