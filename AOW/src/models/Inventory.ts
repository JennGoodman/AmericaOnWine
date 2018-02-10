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
      this.year = null;
      this.price = null;
      this.submitted = null;
      this.description = null;
      this.imageUrl = null;
    }
  }
