const awaitTimeout = (delay, reason) =>

  new Promise((resolve, reject) =>
    setTimeout(
      () => (reason === undefined ? resolve() : reject(reason)),
      delay
    )

  );

  console.log(awaitTimeout(1000));