import { User } from './User';
import { Brand } from './Brand';
import { Country } from './Country';
import { SubType } from './SubType';

export class Inventory {
    id: number;
    name: string;
    brand: Brand;
    user: User;
    country: Country;
    sub_type: SubType;
    volume: number;
    year: number;
    price: number;
    quantity: number;
    submitted: Date;
    description: string;
    imageUrl: string;

    constructor() {
      this.id = null;
      this.name = null;
      this.brand = null;
      this.user = null;
      this.country = null;
      this.sub_type = null;
      this.volume = null;
      this.year = null;
      this.price = null;
      this.quantity = null;
      this.submitted = null;
      this.description = null;
      this.imageUrl = null;
    }

    setVals(id: number, name: string, brand: string, country: string, type: string,
       subtype: string, volume: number, year: number, price: number, description: string, image: string) {
      this.id = id;
      this.name = name;
      this.brand = new Brand();
      this.brand.name = brand;
      this.country = new Country();
      this.country.name = country;
      this.sub_type = new SubType();
      this.sub_type.name = subtype;
      this.sub_type.type.name = type;
      this.volume = volume;
      this.year = year;
      this.price = price;
      this.description = description;
      this.imageUrl = image;
      return this;
  }
}
