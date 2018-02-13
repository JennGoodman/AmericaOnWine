export class User {
    id: number;
    username: string;
    password: string;
    email: string;
    role: number;
    active: number;
    cancelled: number;
    ADMIN: number;
    RETAILER: number;
    CUSTOMER: number;

    constructor() {
      this.id = 0;
      this.username = '';
      this.password = '';
      this.email = '';
      this.role = 0;
      this.active = 0;
      this.cancelled = 0;
      const ADMIN = 0;
      const RETAILER = 1;
      const CUSTOMER = 2;
    }
  }
