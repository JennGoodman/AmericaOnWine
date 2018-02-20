import { Inventory } from './Inventory';

export class Transaction {
    id: number;
    orderNumber: number;
    inv: Inventory;
    quantity: number;
    userId: number;
    total: number;
    rating: number;
    transactionDate: Date;
    comments: string;

    constructor() {
      this.id = 0;
      this.orderNumber = null;
      this.inv = null;
      this.quantity = null;
      this.userId = null;
      this.total = null;
      this.rating = null;
      this.transactionDate = null;
      this.comments = null;
    }

    setVals(on: number, invId: Inventory, quantity: number, userId: number, total: number) {
      this.orderNumber = on;
      this.inv = invId;
      this.quantity = quantity;
      this.userId = userId;
      this.total = total;
      return this;
    }
  }
