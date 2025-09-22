#!/bin/bash
set -e

BASE_DIR="src/main/java/com/example/orderservice"

echo "== Создание доменных папок =="

for domain in order payment delivery customer common; do
  mkdir -p $BASE_DIR/$domain/{controller,dto,entity,mapper,repository,service}
done

echo "== Копирование файлов по доменам =="

# --- ORDER ---
cp $BASE_DIR/dto/Order*Dto.java              $BASE_DIR/order/dto/ 2>/dev/null || true
cp $BASE_DIR/entity/Order*.java              $BASE_DIR/order/entity/ 2>/dev/null || true
cp $BASE_DIR/mapper/Order*Mapper.java        $BASE_DIR/order/mapper/ 2>/dev/null || true
cp $BASE_DIR/repository/Order*Repository.java $BASE_DIR/order/repository/ 2>/dev/null || true
cp $BASE_DIR/service/Order*Service.java      $BASE_DIR/order/service/ 2>/dev/null || true

# --- PAYMENT ---
cp $BASE_DIR/dto/Payment*Dto.java            $BASE_DIR/payment/dto/ 2>/dev/null || true
cp $BASE_DIR/entity/Payment*.java            $BASE_DIR/payment/entity/ 2>/dev/null || true
cp $BASE_DIR/mapper/Payment*Mapper.java      $BASE_DIR/payment/mapper/ 2>/dev/null || true
cp $BASE_DIR/repository/Payment*Repository.java $BASE_DIR/payment/repository/ 2>/dev/null || true
cp $BASE_DIR/service/Payment*Service.java    $BASE_DIR/payment/service/ 2>/dev/null || true

# --- DELIVERY ---
cp $BASE_DIR/dto/*Delivery*Dto.java          $BASE_DIR/delivery/dto/ 2>/dev/null || true
cp $BASE_DIR/dto/*Schedule*Dto.java          $BASE_DIR/delivery/dto/ 2>/dev/null || true
cp $BASE_DIR/entity/Delivery*.java           $BASE_DIR/delivery/entity/ 2>/dev/null || true
cp $BASE_DIR/entity/*Schedule*.java          $BASE_DIR/delivery/entity/ 2>/dev/null || true
cp $BASE_DIR/mapper/Delivery*Mapper.java     $BASE_DIR/delivery/mapper/ 2>/dev/null || true
cp $BASE_DIR/mapper/*Schedule*Mapper.java    $BASE_DIR/delivery/mapper/ 2>/dev/null || true
cp $BASE_DIR/repository/Delivery*Repository.java $BASE_DIR/delivery/repository/ 2>/dev/null || true
cp $BASE_DIR/repository/*Schedule*Repository.java $BASE_DIR/delivery/repository/ 2>/dev/null || true

# --- CUSTOMER ---
cp $BASE_DIR/dto/Customer*Dto.java           $BASE_DIR/customer/dto/ 2>/dev/null || true
cp $BASE_DIR/entity/Customer*.java           $BASE_DIR/customer/entity/ 2>/dev/null || true
cp $BASE_DIR/mapper/Customer*Mapper.java     $BASE_DIR/customer/mapper/ 2>/dev/null || true
cp $BASE_DIR/repository/Customer*Repository.java $BASE_DIR/customer/repository/ 2>/dev/null || true
cp $BASE_DIR/service/Customer*Service.java   $BASE_DIR/customer/service/ 2>/dev/null || true
cp $BASE_DIR/controller/Customer*Controller.java $BASE_DIR/customer/controller/ 2>/dev/null || true

# --- COMMON ---
cp $BASE_DIR/dto/*.java                      $BASE_DIR/common/dto/ 2>/dev/null || true
cp $BASE_DIR/entity/*.java                   $BASE_DIR/common/entity/ 2>/dev/null || true
cp $BASE_DIR/mapper/*.java                   $BASE_DIR/common/mapper/ 2>/dev/null || true
cp $BASE_DIR/repository/*.java               $BASE_DIR/common/repository/ 2>/dev/null || true
cp $BASE_DIR/service/*.java                  $BASE_DIR/common/service/ 2>/dev/null || true
cp $BASE_DIR/controller/*.java               $BASE_DIR/common/controller/ 2>/dev/null || true
