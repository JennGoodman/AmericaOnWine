import { User } from './User';
import { Brand } from './Brand';
import { Country } from './Country';
import { SubType } from './SubType';
import { Type } from './Type';

export class Inventory {
    id: number;
    name: string;
    brand: Brand;
    user: User;
    country: Country;
    subType: SubType;
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
      this.brand = new Brand();
      this.user = null;
      this.country = new Country();
      this.subType = new SubType();
      this.subType.type = new Type();
      this.volume = null;
      this.year = null;
      this.price = null;
      this.quantity = null;
      this.submitted = null;
      this.description = null;
      this.imageUrl = null;
    }
}
