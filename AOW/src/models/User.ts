export class User {
    id: number;
    username: string;
    password: string;
    email: string;
    role: number;
    active: number;
    cancelled: number;

    constructor() {
      this.id = null;
      this.username = null;
      this.password = null;
      this.email = null;
      this.role = null;
      this.active = null;
      this.cancelled = null;
    }
  }
