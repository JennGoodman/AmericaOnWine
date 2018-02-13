import { User } from './User';
import { Brand } from './Brand';
import { Country } from './Country';
import { Type } from './Type';
import { SubType } from './SubType';

export class Inventory {
    id: number;
    name: string;
    brand: Brand;
    user: User;
    country: Country;
    type: Type;
    sub_type: SubType;
    volume: number;
    year: number;
    price: number;
    submitted: Date;
    description: string;
    imageUrl: string;

    constructor() {
      this.id = null;
      this.name = null;
      this.brand = null;
      this.user = null;
      this.country = null;
      this.type = null;
      this.sub_type = null;
      this.volume = null;
      this.year = null;
      this.price = null;
      this.submitted = null;
      this.description = null;
      this.imageUrl = null;
    }

    setVals(id: number, name: string, brand: string, country: string, type: string,
       subtype: string, volume: number, year: number, price: number, description: string, image: string) {
      this.id = id;
      this.name = name;
      this.brand = new Brand();
      this.brand.brand = brand;
      this.country = new Country();
      this.country.country = country;
      this.type = new Type();
      this.type.type = type;
      this.sub_type = new SubType();
      this.sub_type.subType = subtype;
      this.volume = volume;
      this.year = year;
      this.price = price;
      this.description = description;
      this.imageUrl = image;
      return this;
  }
}
