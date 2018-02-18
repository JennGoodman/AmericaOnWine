export class Transaction {
    id: number;
    orderNumber: number;
    inventoryId: number;
    quantity: number;
    userId: number;
    total: number;
    rating: number;
    transactionDate: Date;
    comments: string;

    constructor() {
      this.id = null;
      this.orderNumber = null;
      this.inventoryId = null;
      this.quantity = null;
      this.userId = null;
      this.total = null;
      this.rating = null;
      this.transactionDate = null;
      this.comments = null;
    }

    setVals(on: number, invId: number, quantity: number, userId: number, total: number) {
      this.orderNumber = on;
      this.inventoryId = invId;
      this.quantity = quantity;
      this.userId = userId;
      this.total = total;
      return this;
    }
  }
