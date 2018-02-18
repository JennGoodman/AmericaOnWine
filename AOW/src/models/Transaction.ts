import { Inventory } from './Inventory';

export class Transaction {
    id: number;
    orderNumber: number;
    inventory: Inventory;
    quantity: number;
    userId: number;
    total: number;
    rating: number;
    transactionDate: Date;
    comments: string;

    constructor() {
      this.id = null;
      this.orderNumber = null;
      this.inventory = null;
      this.quantity = null;
      this.userId = null;
      this.total = null;
      this.rating = null;
      this.transactionDate = null;
      this.comments = null;
    }

    setVals(on: number, invId: Inventory, quantity: number, userId: number, total: number) {
      this.orderNumber = on;
      this.inventory = invId;
      this.quantity = quantity;
      this.userId = userId;
      this.total = total;
      return this;
    }
  }
